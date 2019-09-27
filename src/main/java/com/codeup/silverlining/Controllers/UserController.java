package com.codeup.silverlining.Controllers;

import com.codeup.silverlining.Model.Post;
import com.codeup.silverlining.Model.Review;
import com.codeup.silverlining.Model.User;
import com.codeup.silverlining.Repo.PostRepo;
import com.codeup.silverlining.Repo.ReviewRepo;
import com.codeup.silverlining.Repo.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    private ReviewRepo reviewDao;
    private UserRepo userDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepo useDao, ReviewRepo reviewDao, PasswordEncoder passwordEncoder){
        this.reviewDao = reviewDao;
        this.userDao = useDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/signup")
    public String viewSignupForm(){
        return "Users/signUp";
    }

    @GetMapping("/signup/volunteer")
    public String viewVolForm(Model model){
        model.addAttribute("user", new User());
        return "Users/volunteerSignUp";
    }

    @PostMapping("/signup/volunteer")
    public String submitCreateForm(@ModelAttribute User user, Model model){
        if(user.getUsername().equals("") ||
           user.getPassword().equals("") ||
           user.getEmail().equals("")||
           (user.getRole() == 1 && user.getPhoto().equals(""))){
            model.addAttribute("usercache",user);
            return "Users/volunteerSignUp";
        }
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/profile";
    }

    @GetMapping("/signup/senior")
    public String viewSeniorForm(Model model){
        model.addAttribute("user", new User());
        return "Users/seniorSignUp";
    }

    @PostMapping("/signup/senior")
    public String submitCreateFormSenior(@ModelAttribute User user, Model model){
        if(user.getUsername().equals("") ||
           user.getPassword().equals("") ||
           user.getEmail().equals("")||
           (user.getRole() == 2 && user.getAddress().equals(""))) {
            model.addAttribute("usercache",user);
            return "Users/seniorSignUp";
        }
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/profile";
    }

//    @GetMapping("/profile")
////    public String viewProfile(Model model){
////        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////        User currentUser = userDao.findById(user.getId());
////        model.addAttribute("user", currentUser);
////        return "redirect:/profile/"+user.getId();
////    }

    @GetMapping("/profile/{id}")
    public String getUserProfile(@PathVariable long id, Model model){
        User user = userDao.findById(id);
        if(user.getRole() == 1){
            Iterable<Review> reviews = reviewDao.findAllByuser_id(id);
            model.addAttribute("reviews",reviews);
        }
        model.addAttribute("user",user);
        return "Users/profile";
    }
    @PostMapping("/profile/{id}/delete")
    public String delete(@PathVariable long id){
        userDao.delete(id);
        return "home";
    }

    @GetMapping("/profile/{id}/edit")
    public String getEdit(@PathVariable long id, Model vModel){
        User user = userDao.findOne(id);
        vModel.addAttribute("user",user);
        return "Users/editInfo";
    }


    @PostMapping("/profile/edit")
    public String update(@ModelAttribute User user, @RequestParam(name="verify")String verify){
        String verifyHash = passwordEncoder.encode(verify);
        String oldpw = userDao.findOne(user.getId()).getPassword();
        if(verifyHash.equals(oldpw)){
            String hash = passwordEncoder.encode(user.getPassword());
            user.setPassword(hash);
            userDao.save(user);
            return "redirect:/profile";

        }else{
            return "redirect:/profile/"+user.getId()+"/edit";
        }

    }


}

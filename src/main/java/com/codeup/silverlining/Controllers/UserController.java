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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;


@Controller
public class UserController {

    private ReviewRepo reviewDao;
    private UserRepo userDao;
    private PostRepo postDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepo useDao, PostRepo postDao, ReviewRepo reviewDao, PasswordEncoder passwordEncoder){
        this.reviewDao = reviewDao;
        this.userDao = useDao;
        this.postDao = postDao;
        this.passwordEncoder = passwordEncoder;
    }
    @GetMapping("/profile")
    public String loginRedirect(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userDao.findById(user.getId());
        return "redirect:/profile/"+currentUser.getId();
    }

    @GetMapping("/profile/{id}")
    public String getUserProfile(@PathVariable long id, Model model){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM uuuu hh:mm a");
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userSesh = userDao.findById(loggedInUser.getId());
        model.addAttribute("userSesh",userSesh);
        User user = userDao.findById(id);
        model.addAttribute("user",user);
        HashMap<Long, String> hmap = new HashMap<>();
        if(user.getRole() == 1){
            Iterable<Review> reviews = reviewDao.findAllByuser_id(id);
            Iterable<Post> tasks = user.getTasks();
            for (Post task : tasks) {
                LocalDateTime ldt = LocalDateTime.parse(task.getDate(), formatter);
                String gregDate = dtf.format(ldt);
                hmap.put(task.getId(), gregDate);
            }
            model.addAttribute("hmap", hmap);
            model.addAttribute("reviews",reviews);
            model.addAttribute("tasks",tasks);
            return "Users/profileForVolunteer";
        }else{
            Iterable<Post> posts = postDao.findAllByuser_id(id);
                for (Post post : posts) {
                    LocalDateTime ldt = LocalDateTime.parse(post.getDate(), formatter);
                    String gregDate = dtf.format(ldt);
                    hmap.put(post.getId(), gregDate);
                }
                model.addAttribute("posts", posts);
                model.addAttribute("hmap", hmap);
            return "Users/profileForSenior";
        }
    }
    @GetMapping("/signup")
    public String viewSignupForm(Model model){

        return "Users/signUp";
    }

    @GetMapping("/signup/helper")
    public String viewVolForm(Model model){

        model.addAttribute("user", new User());
        return "Users/volunteerSignUp";
    }

    @PostMapping("/signup/helper")
    public String submitCreateForm(@ModelAttribute User user, Model model){
        user.setRole(1);
        if(user.getUsername().equals("") ||
           user.getPassword().equals("") ||
           user.getEmail().equals("")||
           user.getPhoto().equals("")){
            model.addAttribute("usercache",user);
            return "Users/volunteerSignUp";
        }
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/profile/"+user.getId();
    }

    @GetMapping("/signup/senior")
    public String viewSeniorForm(Model model){
        model.addAttribute("user", new User());
        return "Users/seniorSignUp";
    }

    @PostMapping("/signup/senior")
    public String submitCreateFormSenior(@ModelAttribute User user, Model model){
        user.setRole(2);
        if(user.getUsername().equals("") ||
           user.getPassword().equals("") ||
           user.getEmail().equals("") ||
           user.getAddress().equals("")) {
            model.addAttribute("usercache",user);
            return "Users/seniorSignUp";
        }
        if(user.getPhoto().equals("")){
            user.setPhoto("https://cdn.filestackcontent.com/5fSzEWVSAy6r4scwLAuQ");
        }
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/profile/"+user.getId();
    }

    @PostMapping("/profile/{id}/delete")
    public String delete(@PathVariable long id){
        userDao.delete(id);
        return "home";
    }

    @GetMapping("/profile/{id}/edit")
    public String getEdit(@PathVariable long id, Model vModel){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userSesh = userDao.findById(loggedInUser.getId());
        vModel.addAttribute("userSesh",userSesh);
        User user = userDao.findOne(id);
        vModel.addAttribute("user",user);
        return "Users/editInfo";
    }


    @PostMapping("/profile/edit")
    public String update(@ModelAttribute User user, @RequestParam(name="verify")String verify){
        String verifyHash = passwordEncoder.encode(verify);
        String oldpw = userDao.findOne(user.getId()).getPassword();
        if(verifyHash.equals(oldpw) && (user.getPassword() != null)){
            String hash = passwordEncoder.encode(user.getPassword());
            user.setPassword(hash);
        }else{
            user.setPassword(userDao.findOne(user.getId()).getPassword());

        }
        userDao.save(user);
        return "redirect:/profile";
    }
}

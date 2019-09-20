package com.codeup.silverlining.Controllers;

import com.codeup.silverlining.Model.Post;
import com.codeup.silverlining.Model.User;
import com.codeup.silverlining.Repo.PostRepo;
import com.codeup.silverlining.Repo.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.crypto.password.PasswordEncoder;


@Controller
public class UserController {


    private PostRepo postDao;
    private UserRepo userDao;

    public UserController(UserRepo useDao, PostRepo postDao){
        this.postDao = postDao;
        this.userDao = useDao;
    }

    @GetMapping("/signup")
    public String viewSignupForm(){
        return "Users/SignUp";
    }

    @GetMapping("/signup/volunteer")
    public String viewVolForm(Model model){
        model.addAttribute("user", new User());
        return "Users/volunteerSignUp";
    }

    @PostMapping("/signup/volunteer")
    public String submitCreateForm(@ModelAttribute User user,PasswordEncoder passwordEncoder, Model model){
        if(user.getUsername().equals("") ||
           user.getPassword().equals("") ||
           user.getEmail().equals("")||
           (user.getRole() == 1 && user.getPhoto().equals(""))){
            model.addAttribute("usercache",user);
            return "users/volunteerSignUp";
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
    public String submitCreateFormSenior(@ModelAttribute User user,PasswordEncoder passwordEncoder, Model model){
        if(user.getUsername().equals("") ||
           user.getPassword().equals("") ||
           user.getEmail().equals("")||
           (user.getRole() == 2 && user.getAddress().equals(""))) {
            model.addAttribute("usercache",user);
            return "users/seniorSignUp";
        }
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/profile";
    }


    @GetMapping("/profile")
    public String viewProfile(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userDao.findById(user.getId());
        model.addAttribute("user", currentUser);
        return "redirect:/profile/"+user.getId();
    }

    @GetMapping("/profile/{id}")
    public String getUserProfile(@PathVariable long id, Model model){
        User user = userDao.findById(id);

//        Iterable<Post> posts = postDao.findAll();
        try{
            User userSesh = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User currentUser = userDao.findById(userSesh.getId());
            model.addAttribute("userSesh",currentUser);
        }catch(Exception e){

        }
//        ArrayList<Post> formatedPosts = new ArrayList<>();
//        for(Post post : posts) {
//            if(post.getUser().getId() == user.getId()) {
//                Post newPost = new Post(post);
//                if (newPost.getBody().length() >= 200) {
//                    newPost.setBody(newPost.getBody().substring(0, 200) + "...");
//                }
//                formatedPosts.add(newPost);
//            }
//        }
//        Iterable<Post> formatedResults = formatedPosts;
//        model.addAttribute("posts", formatedResults);
        model.addAttribute("user",user);
        return "Users/profile";
    }

}

package com.codeup.silverlining.Controllers;

import com.codeup.silverlining.Model.User;
import com.codeup.silverlining.Repo.PostRepo;
import com.codeup.silverlining.Repo.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class ReviewController {

    private PostRepo postDao;
    private UserRepo userDao;
    private PasswordEncoder passwordEncoder;

    public ReviewController(UserRepo useDao, PostRepo postDao, PasswordEncoder passwordEncoder){
        this.postDao = postDao;
        this.userDao = useDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/review")
    public String viewProfile(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userDao.findById(user.getId());
        model.addAttribute("user", currentUser);
        return "redirect:/review/"+user.getId();
    }

    @GetMapping("/review/{id}")
    public String leaveAReview(@PathVariable long id, Model model){
        User user = userDao.findById(id);
        model.addAttribute("user",user);
        return "review";
    }
}

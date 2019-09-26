package com.codeup.silverlining.Controllers;

import com.codeup.silverlining.Model.Review;
import com.codeup.silverlining.Model.User;
import com.codeup.silverlining.Repo.PostRepo;
import com.codeup.silverlining.Repo.ReviewRepo;
import com.codeup.silverlining.Repo.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReviewController {

    private ReviewRepo reviewDao;
    private UserRepo userDao;
    private PasswordEncoder passwordEncoder;

    public ReviewController(UserRepo useDao, ReviewRepo reviewDao, PasswordEncoder passwordEncoder){
        this.reviewDao = reviewDao;
        this.userDao = useDao;
        this.passwordEncoder = passwordEncoder;
    }

//    @GetMapping("/review")
//    public String viewProfile(Model model){
////        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////        User currentUser = userDao.findById(user.getId());
////        model.addAttribute("user", currentUser);
//
//        model.addAttribute("review", new Review());
//    }

    @GetMapping("/review/{id}")
    public String leaveAReview(@PathVariable long id, Model model){
        User user = userDao.findById(id);
        User reviewerUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User reviewer = userDao.findById(user.getId());
        model.addAttribute("user",user);
        model.addAttribute("reviewer",reviewer);
        model.addAttribute("review", new Review());
        return "Users/reviewUser";
    }

    @PostMapping("/review")
    public String submitReview(@ModelAttribute Review review){
        reviewDao.save(review);
        return "redirect: /profile/"+review.getUser().getId();
    }
}

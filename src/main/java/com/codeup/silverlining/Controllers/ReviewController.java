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
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/review/{id}")
    public String leaveAReview(@PathVariable long id, Model model){
        User volUser = userDao.findOne(id);
        User SeniorUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User senior = userDao.findOne(SeniorUser.getId());

        System.out.println(senior);
        System.out.println(volUser);

        model.addAttribute("vol",volUser);
        model.addAttribute("senior",senior);
        model.addAttribute("review", new Review());
        return "Users/reviewUser";
    }

    @PostMapping("/review")
    public String submitReview(@ModelAttribute Review review,
                               @RequestParam(name="senior") User senior,
                               @RequestParam(name="volunteer") User volunteer,
                               @RequestParam(name="description") String description){
        review.setReviewer(senior);
        review.setUser(volunteer);
        review.setDescription(description);
        reviewDao.save(review);
        return "redirect:/profile/"+review.getUser().getId();
    }
}

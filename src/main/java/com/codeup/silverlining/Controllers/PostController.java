package com.codeup.silverlining.Controllers;

import com.codeup.silverlining.Model.Post;
import com.codeup.silverlining.Model.User;
import com.codeup.silverlining.Repo.PostRepo;
import com.codeup.silverlining.Repo.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PostController {

    private PostRepo postDao;
    private UserRepo userDao;
    public PostController(PostRepo postDao, UserRepo userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @PostMapping("/create")
    public String submitPost(@ModelAttribute Post post,
                             @RequestParam(name = "date") String date,
                             @RequestParam(name = "time") String time){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String myDateString = date +" "+time;
        long unixDate;
        try {
            Date newDate = dateFormat.parse(myDateString);
            unixDate = newDate.getTime();
            post.setDate(unixDate);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("failed to convert date");
        }

        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/create")
    public String createPost(){
        return "Posts/PostsForm";
    }
    @GetMapping("/create/delivery")
    public String createDeliveryPost(){
        return "Posts/DeliveryPosts";
    }
    @GetMapping("create/residence")
    public String createResidencePost(){
        return "Posts/ResidenceAssistance";
    }

}

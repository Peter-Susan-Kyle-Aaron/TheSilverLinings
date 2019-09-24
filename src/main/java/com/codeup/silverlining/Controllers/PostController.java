package com.codeup.silverlining.Controllers;

import com.codeup.silverlining.Model.Post;
import com.codeup.silverlining.Model.User;
import com.codeup.silverlining.Repo.PostRepo;
import com.codeup.silverlining.Repo.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String index(Model vModel) {
        vModel.addAttribute("posts", postDao.findAll());
        return "posts/index";
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

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    public String individual(@PathVariable long id, Model vModel) {
        try {
            User userSession = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User findUser  = userDao.findById(userSession.getId());
            vModel.addAttribute("findUser", findUser);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Post post = postDao.findOne(id);
            vModel.addAttribute("post", post);
        }
        return "posts/IndividualPost";
    }
//    @GetMapping("/posts/{id}")
//    public String individual(@PathVariable long id, Model vModel){
//        Post post = postDao.findOne(id);
//        vModel.addAttribute("post", post);
//        return "IndividualPost";
//    }

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

    @PostMapping("posts/{id}/delete")
    public String delete(@PathVariable long id) {
        postDao.delete(id);
        return "redirect:/posts";
    }
}

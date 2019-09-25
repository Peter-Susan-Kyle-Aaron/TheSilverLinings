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
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;

@Controller
public class PostController {

    private PostRepo postDao;
    private UserRepo userDao;
    public PostController(PostRepo postDao, UserRepo userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @PostMapping("/create/delivery")
    public String submitDeliveryPost(@ModelAttribute Post post,
                             @RequestParam(name = "dates") String dates,
                             @RequestParam(name = "time") String times,
                             @RequestParam(name = "recurrence") String recur,
                             @RequestParam(name = "endDate") String endDate){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        post.setCategory("Delivery");
        post.setTitle("Delivery at "+post.getLocation());


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startDate = LocalDateTime.parse(dates+" "+times, formatter);

        int i = 0;
        if(!recur.equals("")) {
            LocalDateTime endate = LocalDateTime.parse(endDate+" "+times, formatter);
            do{
                Post newPost = new Post();
                newPost.setLocation(post.getLocation());
                newPost.setTitle(post.getTitle());
                newPost.setBody(post.getBody());
                newPost.setCategory(post.getCategory());
                newPost.setUser(post.getUser());

                postDao.save(newPost);

                TemporalAdjuster temporalAdjuster;
                switch(recur) {
                    case "Daily":
                        if(i < 21) {
                            temporalAdjuster = t -> t.plus(Period.ofDays(1));
                            startDate = startDate.with(temporalAdjuster);
                        }
                        break;

                    case "Weekly":
                        if(i < 4) {
                            temporalAdjuster = t -> t.plus(Period.ofWeeks(1));
                            startDate = startDate.with(temporalAdjuster);
                        }
                        break;
                    case "Monthly":
                        if(i < 12) {
                            temporalAdjuster = t -> t.plus(Period.ofMonths(1));
                            startDate = startDate.with(temporalAdjuster);
                        }
                        break;
                }
                newPost.setDate(startDate.toEpochSecond(ZoneOffset.UTC));
                i++;
            }while(startDate.compareTo(endate) < 0);
        }else{
            post.setDate(startDate.toEpochSecond(ZoneOffset.UTC));
            postDao.save(post);
        }
        return "redirect:/posts";
    }
    @PostMapping("/create/assistance")
    public String submitPost(@ModelAttribute Post post,
                             @RequestParam(name = "dates") String dates,
                             @RequestParam(name = "time") String times,
                             @RequestParam(name = "extra") String extra,
                             @RequestParam(name = "timeForTask") String timeForTask,
                             @RequestParam(name = "numberOfWorkers") String numberOfWorkers){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        post.setCategory("Assitance");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startDate = LocalDateTime.parse(dates+" "+times, formatter);

        post.setDate(startDate.toEpochSecond(ZoneOffset.UTC));

        if(post.getLocation().equals("")){
            post.setLocation(user.getAddress());
        }
        post.setBody("Estimated time of completion: "+timeForTask+
                    "\nEstimated volunteers needed: "+numberOfWorkers+
                    "\n"+extra);
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/create")
    public String createPost(){
        return "Posts/PostsForm";
    }
    @GetMapping("/create/delivery")
    public String createDeliveryPost(Model model){
        model.addAttribute("post", new Post());
        return "Posts/DeliveryPosts";
    }
    @GetMapping("create/residence")
    public String createResidencePost(Model model){
        model.addAttribute("post", new Post());
        return "Posts/ResidenceAssistance";
    }

    @GetMapping("/posts")
    public String index(Model vModel) {
        vModel.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
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
}

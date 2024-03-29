package com.codeup.silverlining.Controllers;

import com.codeup.silverlining.Model.Post;
import com.codeup.silverlining.Model.User;
import com.codeup.silverlining.Repo.PostRepo;
import com.codeup.silverlining.Repo.UserRepo;
import com.codeup.silverlining.Services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("Duplicates")
@Controller
public class PostController {

    private PostRepo postDao;
    private UserRepo userDao;
    private final EmailService emailService;

    public PostController(PostRepo postDao, UserRepo userDao, EmailService emailService){
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
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
        post.setTitle("Delivery from "+post.getLocation());
        post.setComplete(false);


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm a");
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
                newPost.setComplete(false);

                newPost.setDate(startDate.toString().replace("T"," "));
                postDao.save(newPost);

                TemporalAdjuster temporalAdjuster;
                switch(recur) {
                    case "Daily":
                        if(i < 21) {
                            temporalAdjuster = t -> t.plus(Period.ofDays(1));
                            startDate = startDate.with(temporalAdjuster);
                        }else{
                            temporalAdjuster = t -> t.minus(Period.ofDays(1));
                            endate = startDate.with(temporalAdjuster);
                        }
                        break;

                    case "Weekly":
                        if(i < 4) {
                            temporalAdjuster = t -> t.plus(Period.ofWeeks(1));
                            startDate = startDate.with(temporalAdjuster);
                        }else{
                            temporalAdjuster = t -> t.minus(Period.ofWeeks(1));
                            endate = startDate.with(temporalAdjuster);
                        }
                        break;
                    case "Monthly":
                        if(i < 12) {
                            temporalAdjuster = t -> t.plus(Period.ofMonths(1));
                            startDate = startDate.with(temporalAdjuster);
                        }else{
                            temporalAdjuster = t -> t.minus(Period.ofMonths(1));
                            endate = startDate.with(temporalAdjuster);
                        }
                        break;
                }
                i++;
            }while(startDate.compareTo(endate) <= 0);
        }else{
            post.setDate(startDate.toString().replace("T"," "));
            postDao.save(post);
        }
        return "redirect:/tasks";
    }
    @PostMapping("/create/assistance")
    public String submitPost(@ModelAttribute Post post,
                             @RequestParam(name = "recurrence") String recur,
                             @RequestParam(name = "endDate") String endDate,
                             @RequestParam(name = "dates") String dates,
                             @RequestParam(name = "time") String times,
                             @RequestParam(name = "extra") String extra,
                             @RequestParam(name = "timeForTask") String timeForTask,
                             @RequestParam(name = "numberOfWorkers") String numberOfWorkers){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        post.setCategory("Assistance");
        post.setComplete(false);
        post.setBody("It will take "+timeForTask+",  you will need "+numberOfWorkers+" helper,  and "+extra);
        if(post.getLocation().equals("")){
            post.setLocation(user.getAddress());
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm a");
        LocalDateTime startDate = LocalDateTime.parse(dates+" "+times, formatter);

        int i = 0;
        if(!recur.equals("")) {
            LocalDateTime endate = LocalDateTime.parse(endDate + " " + times, formatter);
            do {
                Post newPost = new Post();
                newPost.setLocation(post.getLocation());
                newPost.setTitle(post.getTitle());
                newPost.setBody(post.getBody());
                newPost.setCategory(post.getCategory());
                newPost.setUser(post.getUser());
                newPost.setComplete(false);

                newPost.setDate(startDate.toString().replace("T", " "));
                postDao.save(newPost);

                TemporalAdjuster temporalAdjuster;
                switch (recur) {
                    case "Daily":
                        if (i < 21) {
                            temporalAdjuster = t -> t.plus(Period.ofDays(1));
                            startDate = startDate.with(temporalAdjuster);
                        } else {
                            temporalAdjuster = t -> t.minus(Period.ofDays(1));
                            endate = startDate.with(temporalAdjuster);
                        }
                        break;

                    case "Weekly":
                        if (i < 4) {
                            temporalAdjuster = t -> t.plus(Period.ofWeeks(1));
                            startDate = startDate.with(temporalAdjuster);
                        } else {
                            temporalAdjuster = t -> t.minus(Period.ofWeeks(1));
                            endate = startDate.with(temporalAdjuster);
                        }
                        break;
                    case "Monthly":
                        if (i < 12) {
                            temporalAdjuster = t -> t.plus(Period.ofMonths(1));
                            startDate = startDate.with(temporalAdjuster);
                        } else {
                            temporalAdjuster = t -> t.minus(Period.ofMonths(1));
                            endate = startDate.with(temporalAdjuster);
                        }
                        break;
                }
                i++;
            } while (startDate.compareTo(endate) <= 0);

        }else{
            post.setDate(startDate.toString().replace("T"," "));
            postDao.save(post);
        }
        return "redirect:/tasks";
    }

    @GetMapping("/create")
    public String createPost(Model model){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userSesh = userDao.findById(loggedInUser.getId());
        model.addAttribute("userSesh",userSesh);
        if(userSesh.getRole() == 1){
            return "redirect:/";
        }else {
            return "Posts/PostsForm";
        }
    }
    @GetMapping("/create/delivery")
    public String createDeliveryPost(Model model){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userSesh = userDao.findById(loggedInUser.getId());
        model.addAttribute("userSesh",userSesh);
        if(userSesh.getRole() == 1){
            return "redirect:/";
        }else {
            model.addAttribute("post", new Post());
            return "Posts/DeliveryPosts";
        }
    }
    @GetMapping("create/assistance")
    public String createResidencePost(Model model){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userSesh = userDao.findById(loggedInUser.getId());
        model.addAttribute("userSesh",userSesh);
        if(userSesh.getRole() == 1){
            return "redirect:/";
        }else {
            model.addAttribute("post", new Post());
            return "Posts/ResidenceAssistance";
        }
    }

    @GetMapping("/tasks")
    public String index(Model vModel) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm a");

        Iterable<Post> posts = postDao.findAll();
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userSesh = userDao.findById(loggedInUser.getId());
        vModel.addAttribute("userSesh",userSesh);
        HashMap<Long, String> hmap = new HashMap<>();
        HashMap<Long, Boolean> taskmap = new HashMap<>();
        if(userSesh.getRole() == 1) {
            for (Post post : posts) {
                LocalDateTime ldt = LocalDateTime.parse(post.getDate(), formatter);
                String gregDate = dtf.format(ldt);
                hmap.put(post.getId(), gregDate);

                boolean accept = false;
                if(post.getWorkers().size() > 0){
                    accept = true;
                }
                taskmap.put(post.getId(), accept);
            }
            vModel.addAttribute("posts", posts);
        }else{
            ArrayList<Post> listPosts = new ArrayList<>();
            for (Post post : posts){
                if(post.getUser().getId() == userSesh.getId()){
                    LocalDateTime ldt = LocalDateTime.parse(post.getDate(), formatter);
                    String gregDate = dtf.format(ldt);
                    hmap.put(post.getId(), gregDate);
                    listPosts.add(post);
                }
                boolean accept = false;
                if(post.getWorkers().size() > 0){
                    accept = true;
                }
                taskmap.put(post.getId(), accept);
            }
            Iterable<Post> userPosts = listPosts;
            vModel.addAttribute("posts", userPosts);

        }
        vModel.addAttribute("dates", hmap);
        vModel.addAttribute("taskmap", taskmap);
        return "Posts/index";
    }

    @GetMapping("/tasks/{id}")
    public String individual(@PathVariable long id, Model vModel) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm a");
        Post post = postDao.findOne(id);
        User user = userDao.findOne(post.getUser().getId());

        LocalDateTime ldt = LocalDateTime.parse(post.getDate(), formatter);
        String date = dtf.format(ldt);

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userSesh = userDao.findById(loggedInUser.getId());
        vModel.addAttribute("userSesh",userSesh);
        boolean accept = false;
        if(post.getWorkers().size() > 0){
            accept = true;
        }
        vModel.addAttribute("Accepted", accept);

        vModel.addAttribute("date", date);
        vModel.addAttribute("user", user);
        vModel.addAttribute("post", post);

        return "Posts/IndividualPost";
    }

    @GetMapping(path = "tasks/{id}/edit")
    public String edit(@PathVariable long id, Model vModel) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userSesh = userDao.findById(loggedInUser.getId());
        vModel.addAttribute("userSesh",userSesh);
        Post post = postDao.findOne(id);
        if (post.getUser() != userSesh)  {
            return "redirect:/tasks";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        LocalDateTime startDate = LocalDateTime.parse(post.getDate(), formatter);
        LocalTime newtime = startDate.toLocalTime();
//        LocalDate newdate = LocalDate.parse(startDate.toLocalDate().toString(),dateformatter);
        String newdate = startDate.toLocalDate().format(dateformatter);



        vModel.addAttribute("time", newtime);
        vModel.addAttribute("date", newdate);
        vModel.addAttribute("post", post);
        return "Posts/editPost";
    }


    @PostMapping(path = "tasks/edit")
    public String editForm(
                           @RequestParam(name="editId")long id,
                           @RequestParam(name="editTitle")String title,
                           @RequestParam(name="editBody")String body,
                           @RequestParam(name="editCat")String category,
                           @RequestParam(name="editLocation")String location,
                           @RequestParam(name="editDate")String date,
                           @RequestParam(name="editTime")String time) {
        Post updatePost = postDao.findOne(id);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm a");
        LocalDateTime startDate = LocalDateTime.parse(date+" "+time, formatter);

        updatePost.setBody(body);
        updatePost.setTitle(title);
        updatePost.setTitle(category);
        updatePost.setTitle(location);
        updatePost.setDate(startDate.toString());

        postDao.save(updatePost);
        return "redirect:/tasks/"+ updatePost.getId();
    }

    @PostMapping("/tasks/{id}/delete")
    public String delete(@PathVariable long id){
        Post post = postDao.findOne(id);
        List<User> workers = post.getWorkers();
        for(User worker : workers){
            worker.removeTask(post);
        }
        postDao.delete(post);
        return "redirect:/tasks";
    }

    @PostMapping("/accept/{id}")
    public String acceptTask(@PathVariable long id){
        User userSession = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user  = userDao.findById(userSession.getId());
        Post post = postDao.findOne(id);
        List<Post> tasks = user.getTasks();
        tasks.add(post);
        user.setTasks(tasks);
        userDao.save(user);
        emailService.prepareAndSend(post,"Your task has been accepted", "Your task has been accepted by one or more helpers!");
        return "redirect:/tasks";
    }

    @PostMapping("/remove/{id}/{ID}")
    public String removeFromTask(@PathVariable long id, @PathVariable long ID){
        Post post = postDao.findOne(id);
        User user = userDao.findOne(ID);
        user.getTasks().remove(post);
        userDao.save(user);
        return "redirect:/tasks/"+post.getId();
    }
}

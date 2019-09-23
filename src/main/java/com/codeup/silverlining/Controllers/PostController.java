package com.codeup.silverlining.Controllers;

import com.codeup.silverlining.Model.Post;
import com.codeup.silverlining.Model.User;
import com.codeup.silverlining.Repo.PostRepo;
import com.codeup.silverlining.Repo.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepo postDao;
    private final UserRepo userDao;

//    @Autowired
//    private EmailService emailService;

    public PostController(PostRepo postRepository, UserRepo userRepository){
        this.postDao = postRepository;
        this.userDao = userRepository;

    }

    @GetMapping("/posts")
    public String createPost() {
        return "PostsForm";
    }

    @RequestMapping(path = "posts/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable long id, Model vModel) {
        User userSession = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User findUser  = userDao.findById(userSession.getId());
        Post post = postDao.findOne(id);
        if (post.getUser() != findUser)  {
            return "redirect:/posts";
        }
        boolean check = userSession.getId() == post.getUser().getId();
        vModel.addAttribute("editPerm", check);
        vModel.addAttribute("post", post);
        return "posts/edit";
    }


    @RequestMapping(path = "posts/{id}/edit", method = RequestMethod.POST)
    public String editForm(@PathVariable long id,
                           @RequestParam(name="title")String title,
                           @RequestParam(name="body")String body) {
        Post updatePost = postDao.findOne(id);
        updatePost.setBody(body);
        updatePost.setTitle(title);
        postDao.save(updatePost);
        return "redirect:";
    }

    @PostMapping("posts/{id}/delete")
    public String delete(@PathVariable long id) {
        postDao.delete(id);
        return "redirect:/posts";
    }


}

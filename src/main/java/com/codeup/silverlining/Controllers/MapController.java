package com.codeup.silverlining.Controllers;
import com.codeup.silverlining.Model.Post;
import com.codeup.silverlining.Model.User;
import com.codeup.silverlining.Repo.PostRepo;
import com.codeup.silverlining.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
    public class MapController {
    private PostRepo postDao;
    private UserRepo userDao;

    public MapController(UserRepo useDao, PostRepo postDao){
        this.postDao = postDao;
        this.userDao = useDao;
    }

        @GetMapping("/map/{id}")
        public String showFind(Model vmodel, @PathVariable long id){
            Post post = postDao.findOne(id);
            System.out.println(post);
            vmodel.addAttribute("post", post);
            User user = userDao.findOne(post.getUser().getId());
            vmodel.addAttribute("user", user);
            return "/mapbox";
        }
    }


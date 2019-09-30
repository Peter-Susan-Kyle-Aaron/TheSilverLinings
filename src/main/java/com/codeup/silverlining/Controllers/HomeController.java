package com.codeup.silverlining.Controllers;

import com.codeup.silverlining.Model.User;
import com.codeup.silverlining.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private UserRepo userDao;
    @GetMapping("/")
    public String viewHomepage(Model model){
        try {
            User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User userSesh = userDao.findById(loggedInUser.getId());
            model.addAttribute("userSesh", userSesh);
        }catch(Exception e){
            System.out.println("no user logged in");
        }
        return "home";
    }
}

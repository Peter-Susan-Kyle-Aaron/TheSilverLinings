package com.codeup.silverlining.Controllers;

import com.codeup.silverlining.Model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    @GetMapping("/login")
    public String showLoginForm() {
        User user;
        try{
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }catch(Exception e){
            return "Users/login";
        }
        return "home";
    }
}

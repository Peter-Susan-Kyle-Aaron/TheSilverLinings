package com.codeup.silverlining.Controllers;
import com.codeup.silverlining.Model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



    @Controller
    public class MapController {
        @GetMapping("/map")
        public String showFind(Model vmodel){
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            vmodel.addAttribute("user", user);
            return "/mapbox";
        }
    }


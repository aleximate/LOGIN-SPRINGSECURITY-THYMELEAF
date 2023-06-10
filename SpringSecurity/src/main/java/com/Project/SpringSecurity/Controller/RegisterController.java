package com.Project.SpringSecurity.Controller;

import com.Project.SpringSecurity.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;
    @GetMapping ("/login")
    public String startSession(){
        return "login";
    }
    @GetMapping ("/")
    public String seeMainPAge(Model model){
        model.addAttribute("users",userService.ListUsers());
        return "index";
    }
}

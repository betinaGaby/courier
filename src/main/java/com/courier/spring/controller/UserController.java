package com.courier.spring.controller;

import com.courier.spring.model.Usermodel;
import com.courier.spring.service.Implementation.UserImplemantation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    UserImplemantation userimpl;
    @GetMapping("/index")
    public String getHomePage(Model model){
        model.addAttribute("Homepage");
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("loginRequest", new Usermodel());

        return "login";
    }

    @GetMapping("/signUp")
    public String signUpPage(Model model){
        Usermodel user= new Usermodel();
        model.addAttribute("signUp", user);
        return "signUp";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute Usermodel userModel){
        System.out.println("register request: " + userModel);
        Usermodel registerUser = userimpl.createUser(userModel);
        return registerUser == null ? "error_page" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Usermodel userModel, Model model){
        System.out.println("login request: " + userModel);
        Usermodel authenticate = userimpl.findUserByEmail(userModel);

        if(authenticate !=null){
            model.addAttribute("userLogin", authenticate.getEmail());
            return "Userpage";
        }else{
            return "error_page";
        }
    }

}


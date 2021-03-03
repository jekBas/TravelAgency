package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/signUp")
    public String showSignUpPage(Model model){
        User user = new User();
        model.addAttribute("user",user);

        return "signUp";
    }

    @PostMapping("/signUp")
    public String registrationUser(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
//        model.addAttribute("username", user.getUserName());
        model.addAttribute("user",user);

        if(bindingResult.hasErrors()){
            model.addAttribute("user",user);
            return "signUp";
        }

        userService.saveUser(user);
        return "signIn";
    }

}
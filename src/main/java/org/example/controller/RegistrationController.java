package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String showSignUpPage(){

        return "signUp";
    }

    @PostMapping("/signUp")
    public String registrationUser(@Valid @ModelAttribute User user, Errors errors, Model model) {
        model.addAttribute("username", user.getUserName());

        return userService.saveUser(errors, user);
    }

}
package org.example.controller;

import org.example.dto.UserDto;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        UserDto userDto = new UserDto();
        model.addAttribute("userDto",userDto);

        return "signUp";
    }

    @PostMapping("/signUp")
    public String registrationUser(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult, Model model) {
//        model.addAttribute("username", user.getUserName());
        model.addAttribute("userDto",userDto);


        if(bindingResult.hasErrors()){
            model.addAttribute("userDto",userDto);
            return "signUp";
        }


        if(userService.findByEmailOrUsername(userDto.getEmail(),userDto.getUserName()) != null){
            bindingResult.rejectValue("userName", "userDto.userName","An account already exists for this email or username");
            model.addAttribute("userDto", userDto);
            return "signUp";
        }

//        if(userService.findByUsername(userDto.getUserName()) != null){
//            bindingResult.rejectValue("userName", "userDto.userName","An account already exists for this username");
//            model.addAttribute("userDto", userDto);
//            return "signUp";
//
//        }else userService.saveUser(new User(userDto));


        return "signIn";
    }

}
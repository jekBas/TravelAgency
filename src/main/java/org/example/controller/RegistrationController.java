package org.example.controller;

import org.example.dto.UserDto;
import org.example.dto.transformer.UserDtoTransformer;
import org.example.model.Role;
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
    public String showSignUpPage(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "signUp";
    }

    @PostMapping("/signUp")
    public String registrationUser(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult, Model model) {
        model.addAttribute("userDto", userDto);
        model.addAttribute("roles",Role.values());

        if (bindingResult.hasErrors()) {
            model.addAttribute("userDto", userDto);
            return "signUp";
        }

        if (!userService.checkByEmailAndUsername(userDto.getEmail(), userDto.getUserName()).isEmpty()) {
            bindingResult.rejectValue("userName", "userDto.userName", "An account already exists for this email or username");
            model.addAttribute("userDto", userDto);
            return "signUp";
        } else {
            userService.saveUser(UserDtoTransformer.convertUserDtoToUser(userDto));
        }

        return "signIn";
    }
}
package org.example.controller;

import org.example.dto.HotelDto;
import org.example.dto.UserDto;
import org.example.model.Country;
import org.example.model.Hotel;
import org.example.model.Role;
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
public class HotelController {

    @Autowired
    private UserService userService;

    @GetMapping("/addHotel")
    public String showSignUpPage(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "addHotel";
    }

    @PostMapping("/addHotel")
    public String addHotel(@Valid @ModelAttribute HotelDto hotelDto, BindingResult bindingResult, Model model) {
//        model.addAttribute("username", user.getUserName());
        model.addAttribute("hotelDto", hotelDto);
        model.addAttribute("roles", Country.values());


        if (bindingResult.hasErrors()) {
            model.addAttribute("hotelDto", hotelDto);
            return "addHotel";
        }


//        if (!hotelService.findByUsername(hotelDto.getHotelName()) {
//            bindingResult.rejectValue("userName", "userDto.userName", "An account already exists for this email or username");
//            model.addAttribute("hotelDto", hotelDto);
//
//            return "addHotel";
//
//        } else hotelService.saveHotel(new Hotel(hotelDto));

        return "signIn";
    }
}



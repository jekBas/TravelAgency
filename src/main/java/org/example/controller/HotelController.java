package org.example.controller;

import org.example.dto.HotelDto;
import org.example.dto.UserDto;
import org.example.model.Country;
import org.example.model.Hotel;
import org.example.model.Role;
import org.example.model.User;
import org.example.service.HotelService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")

public class HotelController {

    @Autowired
    private UserService userService;
    @Autowired
    private HotelService hotelService;

    @GetMapping("/add")
    public String showSignUpPage(Model model) {
        HotelDto hotelDto = new HotelDto();
        model.addAttribute("hotelDto", hotelDto);
        return "addHotel";
    }

    @PostMapping("/add")
    public String addHotel(@Valid @ModelAttribute HotelDto hotelDto, BindingResult bindingResult, Model model) {
//        model.addAttribute("username", user.getUserName());
        model.addAttribute("hotelDto", hotelDto);
        model.addAttribute("roles", Country.values());


        if (bindingResult.hasErrors()) {
            model.addAttribute("hotelDto", hotelDto);
            return "addHotel";
        }


        if (!hotelService.getAllHotelsInTheCountry(hotelDto.getCountry().name()).isEmpty()) {
            bindingResult.rejectValue("country", "country.hotelName", "Hotel with the same name already exists in this country");
            model.addAttribute("hotelDto", hotelDto);

            return "addHotel";

        } else hotelService.saveHotel(new Hotel(hotelDto));

        return "signIn";
    }
}



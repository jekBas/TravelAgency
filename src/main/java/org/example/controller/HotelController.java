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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/hotel")

public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/add")
    public String showAddHotelForm(Model model) {
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

    @GetMapping("/list")
    public String showHotels(Model model) {
        List<Hotel> hotels = hotelService.getAllHotels();
        model.addAttribute("hotels",hotels);
        model.addAttribute("country",Country.values());
        return "listHotels";
    }

    @RequestMapping("/delete")
    public String deleteHotel(@RequestParam("hotelId") Long id){

        hotelService.deleteHotel(id);

        return "redirect:/hotel/list";
    }

    @GetMapping("/filteredList")
    public String showHotelsByCountry(@RequestParam String country, Model model) {
        List<Hotel> hotels = hotelService.getAllHotelsInTheCountry(country);
        model.addAttribute("hotels",hotels);
        model.addAttribute("country",Country.values());
        return "listHotels";
    }

}



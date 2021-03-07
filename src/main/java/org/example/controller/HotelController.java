package org.example.controller;

import org.example.dto.HotelDto;
import org.example.dto.HotelFilter;
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
    public String addHotel(@Valid @ModelAttribute("hotelDto") HotelDto hotelDto, BindingResult bindingResult, Model model) {
//        model.addAttribute("username", user.getUserName());
//        model.addAttribute("hotelDto", hotelDto);
//        model.addAttribute("roles", Country.values());


        if (bindingResult.hasErrors()) {
            model.addAttribute("hotelDto", hotelDto);
            return "addHotel";
        }


        if (hotelService.chekIfExistHotelByName(new Hotel(hotelDto))) {
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

        HotelFilter filter = new HotelFilter();
        model.addAttribute("filter",filter);
        return "listHotels";
    }

    @RequestMapping("/delete")
    public String deleteHotel(@RequestParam("hotelId") Long id){

        hotelService.deleteHotel(id);

        return "redirect:/hotel/list";
    }

    @RequestMapping("/filteredList")
    public String showHotelsByCountry(@ModelAttribute("filter") HotelFilter filter, Model model) {

        if(filter.getCountry().name().isEmpty()){
            return "redirect:/hotel/list";
        }else{
            List<Hotel> hotels = hotelService.getAllHotelsInTheCountry(filter.getCountry().name());
            model.addAttribute("hotels",hotels);
            model.addAttribute("country",Country.values());
            return "listHotels";
        }

    }

}



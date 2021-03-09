package org.example.controller;

import org.example.dto.HotelDto;
import org.example.dto.HotelDtoTransformer;
import org.example.dto.HotelFilter;
import org.example.model.Country;
import org.example.model.Hotel;
import org.example.service.HotelService;
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

        if (bindingResult.hasErrors()) {
            model.addAttribute("hotelDto", hotelDto);
            return "addHotel";
        }

        if (hotelService.chekIfExistHotelByName(HotelDtoTransformer.convertHotelDtoToHotel(hotelDto))) {
            bindingResult.rejectValue("country", "country.hotelName", "Hotel with the same name already exists");
            model.addAttribute("hotelDto", hotelDto);
            return "addHotel";
        } else {
            hotelService.saveHotel(HotelDtoTransformer.convertHotelDtoToHotel(hotelDto));
        }

        return "signIn";
    }

    @GetMapping("/list")
    public String showHotels(Model model) {
        List<Hotel> hotels = hotelService.getAllHotels();
        model.addAttribute("hotels", hotels);
        model.addAttribute("country", Country.values());

        HotelFilter filter = new HotelFilter();
        model.addAttribute("filter", filter);
        return "listHotels";
    }

    @RequestMapping("/delete")
    public String deleteHotel(@RequestParam("hotelId") Long id) {
        hotelService.deleteHotel(id);
        return "redirect:/hotel/list";
    }

    @RequestMapping("/filteredList")
    public String showHotelsByCountry(@ModelAttribute("filter") HotelFilter filter, Model model) {

        if (filter.getCountry().name().isEmpty()) {
            return "redirect:/hotel/list";
        } else {
            List<Hotel> hotels = hotelService.getAllHotelsInTheCountry(filter.getCountry().name());
            model.addAttribute("hotels", hotels);
            model.addAttribute("country", Country.values());
            return "listHotels";
        }
    }
}
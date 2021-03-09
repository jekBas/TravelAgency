package org.example.controller;

import org.example.dto.HotelFilter;
import org.example.dto.OrderParameters;
import org.example.model.Country;
import org.example.model.Hotel;
import org.example.model.Room;
import org.example.service.HotelService;
import org.example.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
@SessionAttributes("hotelId")
public class OrderController {
    @Autowired
    private  HotelService hotelService;
    @Autowired
    private RoomService roomService;

 @GetMapping("/all")
    public String showFilterForm(Model model){
     HotelFilter filter = new HotelFilter();
     List<Hotel> hotels = hotelService.getAllHotels();
     model.addAttribute("country", Country.values());
     model.addAttribute("filter",filter);
     model.addAttribute("hotels", hotels);
     return "orderPageListHotels";
 }

    @PostMapping("/inCountry")
    public String showLocalHotel(@ModelAttribute("filter") HotelFilter filter, Model model){
       List<Hotel> hotels = hotelService.getAllHotelsInTheCountry(filter.getCountry().name());
       model.addAttribute("hotels",hotels);
        return "orderPageListHotels";
    }

    @GetMapping("/orderForm")
    public String createOrder(@RequestParam("hotelId") Long id, Model model){
        OrderParameters orderParameters = new OrderParameters();
        orderParameters.setHotelId(id);
     model.addAttribute("orderParameters",orderParameters);
     return "orderForm";
    }

    @GetMapping("/showRooms")
    public String showRooms(@ModelAttribute("orderParameters") OrderParameters orderParameters, Model model){
//     List<Room> rooms = roomService.getAvaibleRooms(orderParameters.getHotelId(), orderParameters.getDateFrom(),orderParameters.getDateTo());
//     model.addAttribute("rooms",rooms);
        System.out.println(orderParameters.getHotelId());
        System.out.println(orderParameters.getDateFrom());
        System.out.println(orderParameters.getDateTo());

        return "listRooms";
    }


}

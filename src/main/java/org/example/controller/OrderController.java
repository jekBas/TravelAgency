package org.example.controller;

import org.example.dto.HotelFilter;
import org.example.dto.OrderParameters;
import org.example.model.*;
import org.example.service.HotelService;
import org.example.service.OrderService;
import org.example.service.RoomService;
import org.example.service.UserService;
import org.example.service.details.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/order")
@SessionAttributes("hotelId")
public class OrderController {
    @Autowired
    private  HotelService hotelService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

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
    public String createOrder(@RequestParam("hotelId")Long id, Model model){
     model.addAttribute("hotelId",id);
        OrderParameters orderParameters = new OrderParameters();
     model.addAttribute("orderParameters",orderParameters);
     return "orderForm";
    }

    @RequestMapping("/showRooms")
    public String showRooms(@ModelAttribute("hotelId") Long id,
                            @ModelAttribute("orderParameters") OrderParameters orderParameters, Model model){
     List<Room> rooms = roomService.getAvailableRooms(id,
             roomService.converter(orderParameters.getDateFrom()),
                     roomService.converter(orderParameters.getDateTo()));
     model.addAttribute("orderParameters",orderParameters);
     model.addAttribute("rooms",rooms);


        return "listRooms";
    }

    @RequestMapping("/order")
    public String createOrder(@ModelAttribute("orderParameters") OrderParameters orderParameters, @RequestParam("roomId") Long id,
                              @AuthenticationPrincipal MyUserDetails userDetails){
     User user = userService.findByUsername(userDetails.getUsername());
        System.out.println(user.toString());
        Orders orders = new Orders();
        orders.setUser(user);
        Room room = roomService.getRoomByID(id);
        System.out.println(room.toString());
        orders.setRoom(room);
        orders.setDateFrom(roomService.converter(orderParameters.getDateFrom()));
        orders.setDateTo(roomService.converter(orderParameters.getDateTo()));
     orderService.saveOrder(orders);

     return "redirect:/order/all";
    }



}

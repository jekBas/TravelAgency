package org.example.controller;

import org.example.dto.RoomDto;
import org.example.dto.UserDto;
import org.example.model.Hotel;
import org.example.model.Room;
import org.example.model.RoomType;
import org.example.model.User;
import org.example.service.HotelService;
import org.example.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@SessionAttributes({"roomDto"})
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private HotelService hotelService;

    @GetMapping("/add")
    public String showAddForm(@RequestParam("hotelId") Long id, Model model){
        RoomDto roomDto = new RoomDto();
        Hotel hotel = hotelService.getHotelById(id);
        roomDto.setHotel(hotel);
        model.addAttribute("roomDto",roomDto);
        model.addAttribute("roomType", RoomType.values());
        return "addRoom";
    }

    @PostMapping("/add")
    public String addRoom(@ModelAttribute("roomDto") RoomDto roomDto){

        roomService.saveRoom(new Room(roomDto));

        return "redirect:/hotel/list";
    }
}

package org.example.controller;

import org.example.dto.RoomDto;
import org.example.dto.transformer.RoomDtoTransformer;
import org.example.model.Hotel;
import org.example.model.Room;
import org.example.model.RoomType;
import org.example.service.HotelService;
import org.example.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        List<Room> rooms = roomService.getAllRoomByHotelId(id);
        roomDto.setHotel(hotel);
        model.addAttribute("rooms",rooms);
        model.addAttribute("roomDto",roomDto);
        model.addAttribute("roomType", RoomType.values());
        return "addRoom";
    }

    @PostMapping("/add")
    public String addRoom(@ModelAttribute("roomDto") RoomDto roomDto){
        roomService.saveRoom(RoomDtoTransformer.convertRoomDtoToRoom(roomDto));

        return "redirect:/hotel/list";
    }
}
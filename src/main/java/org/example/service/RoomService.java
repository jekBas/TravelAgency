package org.example.service;

import org.example.model.Room;


import java.time.LocalDate;
import java.util.List;

public interface RoomService {

    void saveRoom(Room room);

    Room getRoomByID(Long id);

    void deleteRoom(Room room);

    List<Room> getAllRoomByHotelId(Long id);

    List<Room> getAvailableRooms(Long hotelId, LocalDate dateFrom, LocalDate dateTo);

    LocalDate converter(String date);
}
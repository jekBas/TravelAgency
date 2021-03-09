package org.example.service;

import org.example.model.Room;

import java.util.List;

public interface RoomService {

    void saveRoom(Room room);

    void deleteRoom(Room room);

    List<Room> getAllRoomByHotelId(Long id);
}
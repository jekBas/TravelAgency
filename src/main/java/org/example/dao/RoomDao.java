package org.example.dao;

import org.example.model.Room;



import java.time.LocalDate;

import java.util.List;

public interface RoomDao {

    void saveRoom(Room room);

    void deleteRoom(Long id);

    List<Room> getAllRoomByHotelId(Long id);

    List<Room> getAvailableRooms(Long hotelId, LocalDate dateFrom, LocalDate dateTo);
}
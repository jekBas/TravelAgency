package org.example.dao;

import org.example.model.Room;



import java.time.LocalDate;

import java.util.List;
import java.util.Set;

public interface RoomDao {

    void saveRoom(Room room);

    void deleteRoom(Long id);

    List<Room> getAllRoomByHotelId(Long id);

    List<Room> getAvailableRooms(Set<Long> id);
    Set<Long> getBookedRoomsId(Long hotelId,LocalDate dateFrom, LocalDate dateTo);
}
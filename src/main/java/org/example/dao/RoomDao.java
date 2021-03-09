package org.example.dao;

import org.example.model.Room;

import java.util.Date;
import java.util.List;

public interface RoomDao {

    void saveRoom(Room room);

    void deleteRoom(Long id);

    List<Room> getAllRoomByHotelId(Long id);

    List<Room> getAvaibleRooms(Long hotelId, Date dateFrom, Date dateTo);
}
package org.example.service.impl;

import org.example.dao.RoomDao;
import org.example.model.Room;
import org.example.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomDao roomDao;

    @Autowired
    public RoomServiceImpl(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @Override
    public void saveRoom(Room room) {
        roomDao.saveRoom(room);
    }

    @Override
    public Room getRoomByID(Long id) {
        return roomDao.getRoomByID(id);
    }

    @Override
    public void deleteRoom(Room room) {
        roomDao.deleteRoom(room.getId());
    }

    @Override
    public List<Room> getAllRoomByHotelId(Long id) {
        return roomDao.getAllRoomByHotelId(id);
    }

    @Override
    public List<Room> getAvailableRooms(Long hotelId, LocalDate dateFrom, LocalDate dateTo) {

       Set<Long> idSet =  roomDao.getBookedRoomsId(hotelId,dateFrom,dateTo);
      return roomDao.getAvailableRooms(idSet);
    }

    @Override
    public LocalDate converter(String date) {
                return LocalDate.parse(date);
    }
}
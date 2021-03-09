package org.example.service.impl;

import org.example.dao.RoomDao;
import org.example.model.Room;
import org.example.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    public void deleteRoom(Room room) {
        roomDao.deleteRoom(room.getId());
    }

    @Override
    public List<Room> getAllRoomByHotelId(Long id) {
        return roomDao.getAllRoomByHotelId(id);
    }

    @Override
    public List<Room> checkAvaibleRooms(Long hotelId, Date dateFrom, Date dateTo) {
        return roomDao.getAvaibleRooms(hotelId,dateFrom,dateTo);
    }
}
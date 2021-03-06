package org.example.service;

import org.example.dao.RoomDao;
import org.example.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
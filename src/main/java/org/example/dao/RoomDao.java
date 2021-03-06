package org.example.dao;

import org.example.model.Room;

public interface RoomDao {

    void saveRoom(Room room);

    void deleteRoom(Long id);
}
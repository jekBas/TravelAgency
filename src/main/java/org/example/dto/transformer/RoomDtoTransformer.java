package org.example.dto.transformer;

import org.example.dto.RoomDto;
import org.example.model.Room;

public class RoomDtoTransformer {

    public static RoomDto convertRoomToRoomDto(Room room) {
        return new RoomDto(
                room.getId(),
                room.getRoomType(),
                room.getHotel());
    }

    public static Room convertRoomDtoToRoom(RoomDto roomDto) {
        Room room = new Room();
        room.setId(roomDto.getId());
        room.setRoomType(roomDto.getRoomType());
        room.setHotel(roomDto.getHotel());

        return room;
    }
}
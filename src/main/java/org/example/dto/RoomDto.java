package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.model.Hotel;
import org.example.model.RoomType;

import javax.persistence.*;

@Getter
@Setter
public class RoomDto {

    private Long id;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    private Hotel hotel;

    public RoomDto() {
    }

    public RoomDto(Long id, RoomType roomType, Hotel hotel) {
        this.id = id;
        this.roomType = roomType;
        this.hotel = hotel;
    }
}
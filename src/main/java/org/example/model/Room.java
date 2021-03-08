package org.example.model;

import lombok.Data;
import org.example.dto.RoomDto;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_type", nullable = false)
    private RoomType roomType;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

//    @OneToMany(mappedBy = "rooms")
//    private List<Order> orders;


    public Room() {
    }

    public Room(RoomDto roomDto) {
        this.id = roomDto.getId();
        this.roomType = roomDto.getRoomType();
        this.hotel = roomDto.getHotel();
    }
}
package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "room_name", unique = true)
    private String roomName;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

//    @OneToMany(mappedBy = "rooms")
//    private List<Order> orders;
}
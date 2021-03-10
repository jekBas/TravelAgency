package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;



@Data
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Column(name = "id_room", nullable = false)
//    private Long id_room;
//
//    @Column(name = "id_user", nullable = false)
//    private Long id_user;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    private LocalDate dateFrom;

    private LocalDate dateTo;
}
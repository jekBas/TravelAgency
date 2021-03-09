package org.example.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "hotel_name", unique = true)
    @Size(min = 3, max = 20, message = "Hotel's name should be between 3 to 20 characters")
    private String hotelName;

    @Enumerated(EnumType.STRING)
    @Column(name = "country")
    private Country country;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Room> rooms;

    public Hotel() {}

    public Hotel(String hotelName, Country country, List<Room> rooms) {
        this.hotelName = hotelName;
        this.country = country;
        this.rooms = rooms;
    }
}
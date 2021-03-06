package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.annotation.ValidName;
import org.example.dto.HotelDto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated
    @NotNull
    private Country country;

    @NotNull
    @ValidName
    private String hotelName;

    public Hotel() {
    }

    public Hotel(HotelDto hotelDto) {
        this.country = hotelDto.getCountry();
        this.hotelName = hotelDto.getHotelName();
    }
}

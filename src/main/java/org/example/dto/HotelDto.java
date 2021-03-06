package org.example.dto;


import lombok.Getter;
import lombok.Setter;
import org.example.annotation.ValidName;
import org.example.model.Country;
import org.example.model.Hotel;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class HotelDto {

    @Enumerated
    @NotNull
    private Country country;

    @ValidName
    private String hotelName;

    public HotelDto() {
    }

    public HotelDto(Hotel hotel) {
        this.country = hotel.getCountry();

    }
}

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
    @NotNull(message = "choose country")
    private Country country;

    @ValidName
    private String hotelName;

    public HotelDto() {
    }

    public HotelDto(Hotel hotel) {
        this.hotelName = hotel.getHotelName();
        this.country = hotel.getCountry();

    }
}
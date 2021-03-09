package org.example.dto;


import lombok.Getter;
import lombok.Setter;
import org.example.annotation.ValidName;
import org.example.model.Country;
import org.example.model.Room;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class HotelDto {

    private Long id;

    @ValidName
    private String hotelName;

    @Enumerated
    @NotNull(message = "choose country")
    private Country country;

    private List<Room> rooms;

    public HotelDto() {}

    public HotelDto(Long id, String hotelName, @NotNull(message = "choose country") Country country, List<Room> rooms) {
        this.id = id;
        this.hotelName = hotelName;
        this.country = country;
        this.rooms = rooms;
    }
}
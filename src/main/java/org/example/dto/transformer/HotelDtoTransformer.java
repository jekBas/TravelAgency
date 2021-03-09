package org.example.dto.transformer;

import org.example.dto.HotelDto;
import org.example.model.Hotel;

public class HotelDtoTransformer {

    public static HotelDto convertHotelToHotelDto(Hotel hotel) {
        return new HotelDto(
                hotel.getId(),
                hotel.getHotelName(),
                hotel.getCountry(),
                hotel.getRooms());
    }

    public static Hotel convertHotelDtoToHotel(HotelDto hotelDto) {
        Hotel hotel = new Hotel();
        hotel.setId(hotelDto.getId());
        hotel.setHotelName(hotelDto.getHotelName());
        hotel.setCountry(hotelDto.getCountry());
        hotel.setRooms(hotel.getRooms());

        return hotel;
    }
}
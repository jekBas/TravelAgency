package org.example.dao;

import org.example.model.Hotel;

import java.util.List;

public interface HotelDao {

    void saveHotel(Hotel hotel);

    List<Hotel> getAllHotelsInTheCountry(String country);

    List<Hotel> getAllHotels();

    void deleteHotel(Long id);

    boolean chekIfExistHotelByName(Hotel hotel);
}
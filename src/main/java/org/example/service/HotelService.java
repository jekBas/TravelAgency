package org.example.service;

import org.example.model.Hotel;

import java.util.List;

public interface HotelService {

    void saveHotel(Hotel hotel);

    List<Hotel> getAllHotelsInTheCountry(String country);

    List<Hotel> getAllHotels();

    void deleteHotel(Long id);
}
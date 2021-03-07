package org.example.service;

import org.example.dao.HotelDao;
import org.example.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelDao hotelDao;

    @Autowired
    public HotelServiceImpl(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }

    @Override
    public void saveHotel(Hotel hotel) {
     hotelDao.saveHotel(hotel);
    }

    @Override
    public List<Hotel> getAllHotelsInTheCountry(String country) {
        return hotelDao.getAllHotelsInTheCountry(country);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelDao.getAllHotels();
    }

    @Override
    public void deleteHotel(Long id) {
        hotelDao.deleteHotel(id);
    }

    @Override
    public boolean chekIfExistHotelByName(Hotel hotel) {
        return hotelDao.chekIfExistHotelByName(hotel);
    }
}
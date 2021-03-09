package org.example.dao;

import org.example.model.Hotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
public class HotelDaoImpl implements HotelDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public HotelDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void saveHotel(Hotel hotel) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(hotel);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        }
    }


    @Override
    public List<Hotel> getAllHotelsInTheCountry(String country) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("From Hotel where country = :country");
        query.setParameter("country", country);
        List<Hotel> resultList = query.getResultList();
        session.close();

        return resultList;
    }

    @Override
    public List<Hotel> getAllHotels() {
        Session session = sessionFactory.openSession();
        List<Hotel> result = session.createQuery("FROM Hotel").list();
        session.close();

        return result;
    }

    @Override
    @Transactional
    public void deleteHotel(Long id) {
        Transaction transaction = null;
        Hotel hotel = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            hotel = session.get(Hotel.class, id);
            session.delete(hotel);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        }
    }

    @Override
    @Transactional
    public boolean chekIfExistHotelByName(Hotel hotel) {
        Session session = sessionFactory.openSession();
        List<Hotel> dbHotels;
        Query query = session.createQuery("from Hotel where hotelName =:name")
                .setParameter("name", hotel.getHotelName());
        dbHotels = query.getResultList();

        if (!dbHotels.isEmpty()) {
            return true;
        } else return false;
    }
}

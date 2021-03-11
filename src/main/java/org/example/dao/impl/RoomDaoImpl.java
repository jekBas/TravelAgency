package org.example.dao.impl;

import org.example.dao.RoomDao;
import org.example.model.Hotel;
import org.example.model.Orders;
import org.example.model.Room;
import org.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class RoomDaoImpl implements RoomDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public RoomDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void saveRoom(Room room) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(room);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        }
    }

    @Override
    public Room getRoomByID(Long id) {
        Session session = sessionFactory.openSession();
        Room room = session.get(Room.class, id);
        session.close();

        return room;
    }


    @Override
    @Transactional
    public void deleteRoom(Long id) {
        Transaction transaction = null;
        Room room = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            room = session.get(Room.class, id);
            session.delete(room);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        }
    }

    @Override
    @Transactional
    public List<Room> getAllRoomByHotelId(Long id) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Room where hotel.id =:id")
                .setParameter("id", id);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Set<Long> getBookedRoomsId(Long hotelId, LocalDate dateFrom, LocalDate dateTo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createNativeQuery("select room_id from orders where :dateFrom  between dateFrom and dateTo or :dateTo between dateFrom and dateTo or dateFrom between :dateFrom  and :dateTo or dateTo between :dateFrom  and :dateTo")
                .setParameter("dateFrom", dateFrom)
                .setParameter("dateTo", dateTo);

        List<BigInteger> ids = query.getResultList();

        Query query1 = session.createNativeQuery("select id from room where hotel_id = " + hotelId + " and id not in(:identifiers)")
                .setParameter("identifiers", ids);

        List<BigInteger> roomIds = query1.getResultList();
        List<Long> longIds = roomIds.stream().map(i -> i.longValue()).collect(Collectors.toList());
        Set<Long> idSet = new HashSet<>();
        idSet.addAll(longIds);


        return idSet;
    }

    @Override
    @Transactional
    public List<Room> getAvailableRooms(Set<Long> values) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Room where id in(:values)")
                .setParameter("values", values);
        List<Room> rooms = query.getResultList();

        return rooms;
    }
}
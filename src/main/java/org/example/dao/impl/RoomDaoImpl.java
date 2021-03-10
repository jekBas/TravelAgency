package org.example.dao.impl;

import org.example.dao.RoomDao;
import org.example.model.Hotel;
import org.example.model.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;

import java.time.LocalDate;
import java.util.List;

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
    public List<Room> getAvailableRooms(Long hotelId, LocalDate dateFrom, LocalDate dateTo) {
        Session session = sessionFactory.openSession();
        System.out.println(dateFrom);
        System.out.println(dateTo);
        System.out.println(dateFrom.toString());
        System.out.println(dateTo.toString());
        Query query = session.createNativeQuery("select * from Room where id not in (select room.id from room join orders ord where " +
                        "('"+dateFrom+"' between ord.dateFrom and ord.dateTo)" +
                        "or ('"+dateTo+"' between ord.dateFrom and ord.dateTo)" +
                        "or (dateFrom between '"+dateFrom+"' and '"+dateTo+"') " +
                        "or (dateTo between '"+dateFrom+"' and '"+dateTo+"'))");
                query.setParameter("dateFrom",dateFrom);
                query.setParameter("dateTo",dateTo);

        List<Room> rooms = query.getResultList();
        System.out.println(rooms.toString());
       return rooms;


//        Query query1 = session.createQuery("from Room where hotel.id =:id and id not in(:list)")
//                .setParameter("id",hotelId)
//                .setParameter("list",identifiers);
//        return query1.getResultList();
//        Query query = session.createQuery
//                ("from Room where id not in" +
//                        "(select id from Order where " +
//                        "(:dateFrom not between dateFrom and dateTo)" +
//                        "or (:dateTo not between dateFrom and dateTo) " +
//                        "or (dateFrom between :dateFrom and :dateTo) " +
//                        "or (dateTo between :dateFrom and :dateTo))")
//                .setParameter("hotelId", hotelId)
//                .setParameter("dateFrom", dateFrom)
//                .setParameter("dateTo", dateTo);
//        return query.getResultList();
    }
}
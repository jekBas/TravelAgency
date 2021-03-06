package org.example.dao;

import org.example.model.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        try (Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.persist(room);
            transaction.commit();
        } catch (Exception e){
            if (transaction != null)
                transaction.rollback();
        }
    }

    @Override
    @Transactional
    public void deleteRoom(Long id) {
        Transaction transaction = null;
        Room room = null;

        try (Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            room = session.get(Room.class, id);
            session.delete(room);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        }
    }
}
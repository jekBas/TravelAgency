package org.example.dao;

import org.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();

            session.persist(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        }
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();

            session.saveOrUpdate(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        }
    }

    @Override
    public User getUserById(Long id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();

        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        List<User> resultList = session.createQuery("From User").list();
        session.close();

        return resultList;
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        Transaction transaction = null;
        User user = null;

        try (Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            user = getUserById(id);
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        }
    }

    @Override
    public User findByUsername(String username) {
        Session session = sessionFactory.openSession();
        Query query =session.createQuery("FROM User  where userName = :name")
                .setParameter("name",username);
        User user = (User) query.getSingleResult();
        session.close();

        return user;
    }
}
package org.example.dao;


import org.example.model.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    void updateUser(User user);

    List<User> getAllUsers();

    void deleteUser(Long id);
}
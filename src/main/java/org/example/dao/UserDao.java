package org.example.dao;


import org.example.model.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    void updateUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    void deleteUser(Long id);

    User findByUsername(String username);

    List<User> checkByEmailAndUsername(String email,String username);

    List<User> checkByIdAndEmailAndUsername(Long id, String email, String userName);
}
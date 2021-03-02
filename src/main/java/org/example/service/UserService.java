package org.example.service;

import org.example.model.User;
import org.springframework.validation.Errors;

import java.util.List;

public interface UserService {

    String saveUser(Errors errors, User user);

    void updateUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    void deleteUser(Long id);

    User findByUsername(String username);
}
package org.example.patronarquitecturabackend.service;

import org.example.patronarquitecturabackend.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    Optional<User> getUserById(Long userId);

    List<User> getAllUsers();

    void deleteUser(Long userId);
}

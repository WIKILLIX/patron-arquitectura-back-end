package org.example.patronarquitecturabackend.service;

import lombok.AllArgsConstructor;
import org.example.patronarquitecturabackend.entity.User;
import org.example.patronarquitecturabackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    /**
     * @param user
     * @return
     */

    public User createUser(User user) {return userRepository.save(user);

    }

    /**
     * @param userId
     * @return
     */
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    /**
     * @return
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * @param userId
     */
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }


}

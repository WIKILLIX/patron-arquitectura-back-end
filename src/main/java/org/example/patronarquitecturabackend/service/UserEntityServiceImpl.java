package org.example.patronarquitecturabackend.service;

import lombok.AllArgsConstructor;
import org.example.patronarquitecturabackend.entity.UserEntity;
import org.example.patronarquitecturabackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserEntityServiceImpl implements UserEntityService {

    private final UserRepository userRepository;

    /**
     * @param user
     * @return
     */
    @Override
    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public Optional<UserEntity> findById(Integer userId) {
        return userRepository.findById(userId);
    }

    /**
     * @return
     */
    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

}

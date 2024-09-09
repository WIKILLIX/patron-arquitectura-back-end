package org.example.patronarquitecturabackend.service;

import org.example.patronarquitecturabackend.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserEntityService {

    org.example.patronarquitecturabackend.entity.UserEntity save(UserEntity user);

    Optional<UserEntity> findById(Integer userId);

    List<UserEntity> findAll();

}

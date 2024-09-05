package org.example.patronarquitecturabackend.repository;

import org.example.patronarquitecturabackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

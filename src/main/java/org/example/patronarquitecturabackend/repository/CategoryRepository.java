package org.example.patronarquitecturabackend.repository;

import org.example.patronarquitecturabackend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

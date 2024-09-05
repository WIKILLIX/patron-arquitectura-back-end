package org.example.patronarquitecturabackend.repository;

import org.example.patronarquitecturabackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

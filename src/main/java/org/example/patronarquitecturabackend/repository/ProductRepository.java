package org.example.patronarquitecturabackend.repository;

import org.example.patronarquitecturabackend.entity.Brand;
import org.example.patronarquitecturabackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);

    List<Product> findByPriceBetween(Double lower, Double higher);

    List<Product> findByBrand(Brand brand);
}

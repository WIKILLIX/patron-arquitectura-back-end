package org.example.patronarquitecturabackend.service;

import org.example.patronarquitecturabackend.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(Product product);

    Optional<Product> getProductById(Long productId);

    List<Product> getAllProducts();

    void deleteProduct(Long productId);
}

package org.example.patronarquitecturabackend.service;

import org.example.patronarquitecturabackend.entity.Category;
import org.example.patronarquitecturabackend.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(Product product);

    Optional<Product> getProductById(Long productId);

    List<Product> getProductByName(String name);

    List<Product> getProductByCategory(Category category);

    List<Product> findByPriceBetween(double min, double max);

    List<Product> getAllProducts();

    void deleteProduct(Long productId);
}

package org.example.patronarquitecturabackend.service;

import lombok.AllArgsConstructor;
import org.example.patronarquitecturabackend.entity.Category;
import org.example.patronarquitecturabackend.entity.Product;
import org.example.patronarquitecturabackend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    /**
     * @param product
     * @return
     */
    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * @param productId
     * @return
     */
    @Override
    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    /**
     * @param name
     * @return
     */

    @Override
    public List<Product> getProductByName(String name) {
        return productRepository.findByName(name);
    }

    /**
     * @param category
     * @return
     */
    @Override
    public List<Product> getProductByCategory(Category category) {
        return List.of();
    }

    /**
     * @param min
     * @param max
     * @return
     */
    @Override
    public List<Product> findByPriceBetween(double min, double max) {
        return List.of();
    }

    /**
     * @return
     */
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * @param productId
     */
    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}

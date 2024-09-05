package org.example.patronarquitecturabackend.service;

import lombok.AllArgsConstructor;
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

    }
}

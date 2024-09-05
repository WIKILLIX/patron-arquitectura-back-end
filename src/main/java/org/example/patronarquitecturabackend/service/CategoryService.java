package org.example.patronarquitecturabackend.service;

import org.example.patronarquitecturabackend.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Category createCategory(Category category);

    Optional<Category> getCategoryById(Long categoryId);

    List<Category> getAllCategories();

    Void deleteCategory(Long categoryId);
}

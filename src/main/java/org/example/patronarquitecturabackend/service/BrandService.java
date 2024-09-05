package org.example.patronarquitecturabackend.service;

import org.example.patronarquitecturabackend.entity.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandService {

    Brand createBrand(Brand brand);

    Optional<Brand> getBrandById(Long brandId);

    List<Brand> getAllBrands();

    void deleteBrand(Long brandId);
}

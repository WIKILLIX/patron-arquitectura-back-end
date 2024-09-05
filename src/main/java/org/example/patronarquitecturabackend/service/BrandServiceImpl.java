package org.example.patronarquitecturabackend.service;

import lombok.AllArgsConstructor;
import org.example.patronarquitecturabackend.entity.Brand;
import org.example.patronarquitecturabackend.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    /**
     * @param brand
     * @return Brand
     */
    @Override
    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    /**
     * @param brandId
     * @return Optional<Brand>
     */
    @Override
    public Optional<Brand> getBrandById(Long brandId) {
        return brandRepository.findById(brandId);
    }

    /**
     * @return List<Brand>
     */
    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    /**
     * @param brandId
     */
    @Override
    public void deleteBrand(Long brandId) {
        brandRepository.deleteById(brandId);
    }
}

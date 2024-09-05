package org.example.patronarquitecturabackend.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.patronarquitecturabackend.entity.Brand;
import org.example.patronarquitecturabackend.service.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/brands")
public class BrandRestController {

    private final BrandService brandService;

    @GetMapping
    public ResponseEntity<List<Brand>> getAllBrands() {
        List<Brand> brands = brandService.getAllBrands();
        return new ResponseEntity<>(brands, HttpStatus.OK);
    }

    @GetMapping("/{brandId}")
    public ResponseEntity<Brand> getBrandById(@PathVariable("brandId") Long brandId) {
        Brand brand = brandService.getBrandById(brandId).orElse(null);
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Brand> createBrand(@RequestBody @Valid Brand brand) {
        Brand newBrand = brandService.createBrand(brand);
        return new ResponseEntity<>(newBrand, HttpStatus.CREATED);
    }

    @DeleteMapping("/{brandId}")
    public ResponseEntity<Void> deleteBrand(@PathVariable("brandId") Long brandId) {
        brandService.deleteBrand(brandId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

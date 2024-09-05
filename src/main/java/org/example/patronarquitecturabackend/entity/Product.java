package org.example.patronarquitecturabackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The name is required")
    @NotBlank(message = "The name is required")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotBlank(message = "The category is required")
    @NotNull(message = "The category is required")
    private Category categoryId;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    @NotBlank(message = "The brand is required")
    @NotNull(message = "The brand is required")
    private Brand brandId;

    @NotBlank(message = "The model is required")
    @NotNull(message = "The model is required")
    private String model;

    @NotNull(message = "The price is required")
    @NotBlank(message = "The price is required")
    private Double price;

    @NotNull(message = "The description is required")
    @NotBlank(message = "The description is required")
    private String description;

    @OneToMany(mappedBy = "productId", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Comment> comments;

}

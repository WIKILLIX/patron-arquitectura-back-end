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

    private String img;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull(message = "The category is required")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    @NotNull(message = "The brand is required")
    private Brand brand;

    @NotNull(message = "The price is required")
    private Double price;

    @NotNull(message = "The description is required")
    @NotBlank(message = "The description is required")
    private String description;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Comment> comments;

}

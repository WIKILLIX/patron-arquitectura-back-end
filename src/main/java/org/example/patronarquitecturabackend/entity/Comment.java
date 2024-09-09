package org.example.patronarquitecturabackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    @NotBlank(message = "The comment is required")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull(message = "The user is required")
    private UserEntity user;


    @ManyToOne
    @JoinColumn(name = "product_id")
    @NotNull(message = "The product is required")
    private Product product;
}

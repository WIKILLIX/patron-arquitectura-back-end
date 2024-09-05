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
    @NotBlank(message = "The user is required")
    @NotNull(message = "The user is required")
    private User userId;


    @ManyToOne
    @JoinColumn(name = "product_id")
    @NotBlank(message = "The product is required")
    @NotNull(message = "The product is required")
    private Product productId;
}

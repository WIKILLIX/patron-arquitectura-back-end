package org.example.patronarquitecturabackend.repository;

import org.example.patronarquitecturabackend.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

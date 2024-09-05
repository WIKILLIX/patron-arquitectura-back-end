package org.example.patronarquitecturabackend.service;

import org.example.patronarquitecturabackend.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    Comment createComment(Comment comment);

    Optional<Comment> getCommentById(Long commentId);

    List<Comment> getAllComments();

    void deleteComment(Long commentId);
}

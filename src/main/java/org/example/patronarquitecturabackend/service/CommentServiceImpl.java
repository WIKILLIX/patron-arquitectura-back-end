package org.example.patronarquitecturabackend.service;

import lombok.AllArgsConstructor;
import org.example.patronarquitecturabackend.entity.Comment;
import org.example.patronarquitecturabackend.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    /**
     * @param comment
     * @return Comment
     */
    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    /**
     * @param commentId
     * @return Optional<Comment>
     */
    @Override
    public Optional<Comment> getCommentById(Long commentId) {
        return commentRepository.findById(commentId);
    }

    /**
     * @return List<Comment>
     */
    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    /**
     * @param commentId
     */
    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}

package cc.subnote.springboot.tutorial.mvc2.comment;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> findByPost(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    public void create(Comment comment) {
        commentRepository.save(comment);
    }

    public void update(Comment comment) {
        commentRepository.update(comment);
    }

    public void delete(Long id) {
        commentRepository.delete(id);
    }

    public Comment get(Long id) {
        return commentRepository.findById(id);
    }
}
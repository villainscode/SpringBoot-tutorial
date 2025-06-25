package cc.subnote.springboot.tutorial.mvc2.comment;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepository {

    private final JdbcTemplate jdbcTemplate;

    public CommentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Comment> findByPostId(Long postId) {
        String sql = "SELECT * FROM comments WHERE post_id = ? ORDER BY created_at ASC";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Comment(
                rs.getLong("id"),
                rs.getLong("post_id"),
                rs.getString("content"),
                rs.getTimestamp("created_at").toLocalDateTime()
        ), postId);
    }

    public void save(Comment comment) {
        String sql = "INSERT INTO comments (post_id, content, created_at) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, comment.getPostId(), comment.getContent(), comment.getCreatedAt());
    }

    public void update(Comment comment) {
        String sql = "UPDATE comments SET content = ? WHERE id = ?";
        jdbcTemplate.update(sql, comment.getContent(), comment.getId());
    }

    public void delete(Long id) {
        String sql = "DELETE FROM comments WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public Comment findById(Long id) {
        String sql = "SELECT * FROM comments WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Comment(
                rs.getLong("id"),
                rs.getLong("post_id"),
                rs.getString("content"),
                rs.getTimestamp("created_at").toLocalDateTime()
        ), id);
    }
}
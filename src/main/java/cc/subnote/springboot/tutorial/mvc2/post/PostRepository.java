package cc.subnote.springboot.tutorial.mvc2.post;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class PostRepository {

    private final JdbcTemplate jdbcTemplate;

    public PostRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Post> findAll(int page, int size) {
        int offset = (page - 1) * size;
        String sql = "SELECT * FROM posts ORDER BY created_at DESC LIMIT ? OFFSET ?";

        return jdbcTemplate.query(sql, (rs, rowNum) -> new Post(
            rs.getLong("id"),
            rs.getString("title"),
            rs.getString("content"),
            rs.getTimestamp("created_at").toLocalDateTime()
        ), size, offset);
    }

    public void save(Post post) {
        String sql = "INSERT INTO posts (title, content, created_at) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, post.getTitle(), post.getContent(), post.getCreatedAt());
    }

    public Post findById(Long id) {
        String sql = "SELECT * FROM posts WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Post(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("content"),
                rs.getTimestamp("created_at").toLocalDateTime()
        ), id);
    }

    public int update(Post post) {
        String sql = "UPDATE posts SET title = ?, content = ? WHERE id = ?";
        return jdbcTemplate.update(sql, post.getTitle(), post.getContent(), post.getId());
    }

    public int delete(Long id) {
        String sql = "DELETE FROM posts WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM posts ", Integer.class);
    }
}
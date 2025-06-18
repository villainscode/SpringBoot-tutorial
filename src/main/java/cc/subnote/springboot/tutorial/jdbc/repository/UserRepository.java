package cc.subnote.springboot.tutorial.jdbc.repository;

import cc.subnote.springboot.tutorial.jdbc.dto.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<User> rowMapper = (rs, rowNum) ->
            new User(rs.getLong("id"), rs.getString("name"), rs.getString("email"));

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM user_test", rowMapper);
    }

    public User findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM user_test WHERE id = ?", rowMapper, id);
    }

    public int save(User user) {
        return jdbcTemplate.update("INSERT INTO user_test (name, email) VALUES (?, ?)",
                user.getName(), user.getEmail());
    }

    public int update(User user) {
        return jdbcTemplate.update("UPDATE user_test SET name = ?, email = ? WHERE id = ?",
                user.getName(), user.getEmail(), user.getId());
    }

    public int delete(Long id) {
        return jdbcTemplate.update("DELETE FROM user_test WHERE id = ?", id);
    }
}
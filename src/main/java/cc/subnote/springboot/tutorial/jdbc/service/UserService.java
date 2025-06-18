package cc.subnote.springboot.tutorial.jdbc.service;

import cc.subnote.springboot.tutorial.jdbc.dto.User;
import cc.subnote.springboot.tutorial.jdbc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public int create(User user) {
        return userRepository.save(user);
    }
    public int update(User user) {
        return userRepository.save(user);
    }

    public int delete(Long id) {
        return userRepository.delete(id);
    }
}

package cc.subnote.springboot.tutorial.jdbc.controller;


import cc.subnote.springboot.tutorial.jdbc.dto.User;
import cc.subnote.springboot.tutorial.jdbc.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        int result = userService.create(user);
        return ResponseEntity.ok("Inserted rows: " + result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        int result = userService.update(user);
        return ResponseEntity.ok("Updated rows: " + result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        int result = userService.delete(id);
        return ResponseEntity.ok("Deleted rows: " + result);
    }
}
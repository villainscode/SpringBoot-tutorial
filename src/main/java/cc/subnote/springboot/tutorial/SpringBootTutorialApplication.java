package cc.subnote.springboot.tutorial;

import cc.subnote.springboot.tutorial.jdbc.User;
import cc.subnote.springboot.tutorial.jdbc.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringBootTutorialApplication implements ApplicationRunner {

    private final UserRepository userRepository;

    public SpringBootTutorialApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTutorialApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        // CREATE
        userRepository.save(new User(null, "홍길동", "hong@example.com"));
        userRepository.save(new User(null, "김개발", "dev@naver.com"));

        // READ
        System.out.println("📋 전체 사용자:");
        userRepository.findAll().forEach(user ->
                System.out.println("👤 " + user.getId() + " | " + user.getName() + " | " + user.getEmail())
        );

        // UPDATE
        User updateUser = userRepository.findById(1L);
        updateUser.setName("홍프로");
        updateUser.setEmail("hongpro@example.com");
        userRepository.update(updateUser);

        // DELETE
        userRepository.delete(2L);
    }
}

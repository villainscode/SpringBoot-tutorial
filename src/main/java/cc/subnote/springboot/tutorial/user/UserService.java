package cc.subnote.springboot.tutorial.user;

public class UserService {
    private final UserRepository userRepository = new UserRepository(); // 직접 객체 생성

    public String getUserName(Long userId) {
        return userRepository.findById(userId);
    }
}
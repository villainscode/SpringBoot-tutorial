package cc.subnote.springboot.tutorial.di.user;

class UserService {
    private final UserRepository userRepository;

    // 생성자 주입을 사용하여 외부에서 의존성 주입
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserName(Long userId) {
        return userRepository.findById(userId);
    }
}
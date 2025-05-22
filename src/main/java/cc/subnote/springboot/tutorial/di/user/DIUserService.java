package cc.subnote.springboot.tutorial.di.user;

class DIUserService {
    private final DIUserRepository DIUserRepository;

    // 생성자 주입을 사용하여 외부에서 의존성 주입
    public DIUserService(DIUserRepository DIUserRepository) {
        this.DIUserRepository = DIUserRepository;
    }

    public String getUserName(Long userId) {
        return DIUserRepository.findById(userId);
    }
}

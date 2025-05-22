package cc.subnote.springboot.tutorial.user;

class UserRepository {
    public String findById(Long userId) {
        return "User_" + userId;
    }
}
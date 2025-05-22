package cc.subnote.springboot.tutorial.di.user;

interface UserRepository {
    String findById(Long userId);
}
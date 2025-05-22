package cc.subnote.springboot.tutorial.di.user;

interface DIUserRepository {
    String findById(Long userId);
}
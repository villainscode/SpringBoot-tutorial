package cc.subnote.springboot.tutorial.di.user;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void getUserNameTest() {
        // Mock 객체 생성
        UserRepository mockRepository = mock(UserRepository.class);

        // Mock 객체의 동작 정의
        when(mockRepository.findById(1L)).thenReturn("MockedUser_1");

        // DI를 활용한 UserService 생성
        UserService userService = new UserService(mockRepository);

        // 테스트 수행
        String userName = userService.getUserName(1L);

        // 검증
        assertEquals("MockedUser_1", userName);
        verify(mockRepository, times(1)).findById(1L); // findById(1L) 호출 검증
    }
}
package cc.subnote.springboot.tutorial.di.user;


import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class DIUserServiceTest {

    @Test
    void getUserNameTest() {
        // Mock 객체 생성
        DIUserRepository mockRepository = mock(DIUserRepository.class);

        // Mock 객체의 동작 정의
        when(mockRepository.findById(1L)).thenReturn("MockedUser_1");

        // DI를 활용한 UserService 생성
        DIUserService userService = new DIUserService(mockRepository);

        // 테스트 수행
        String userName = userService.getUserName(1L);

        // 검증
        assertEquals("MockedUser_1", userName);
        verify(mockRepository, times(1)).findById(1L); // findById(1L) 호출 검증
    }
}
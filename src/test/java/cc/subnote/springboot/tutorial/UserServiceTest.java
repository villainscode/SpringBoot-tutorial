package cc.subnote.springboot.tutorial;

import cc.subnote.springboot.tutorial.user.UserService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void getUserNameTest() {
        UserService userService = new UserService();
        String userName = userService.getUserName(1L);
        assertEquals("User_1", userName);
    }
}
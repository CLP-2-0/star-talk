package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.UserRepository;
import edu.cs.tcu.chineselearningplatform.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;
    @Test
    void testFindByUsername() {
        User user1 = new User("testUser1");

        when(userRepository.findByUsername("testUser1")).thenReturn(user1);

        User u1 = userService.findByUsername("testUser1");

        assertEquals(u1, user1);
    }
}
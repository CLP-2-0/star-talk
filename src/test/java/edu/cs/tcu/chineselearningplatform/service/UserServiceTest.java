package edu.cs.tcu.chineselearningplatform.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import edu.cs.tcu.chineselearningplatform.dao.UserRepository;
import edu.cs.tcu.chineselearningplatform.entity.User;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class UserServiceTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userRepository);
    }

    @Test
    public void testFindByUsername() {
        // create a user object for testing
        User user = new User();
        user.setUsername("testuser");

        // mock the userRepository.findByUsername() method to return the user object when called with "testuser" as argument
        when(userRepository.findByUsername("testuser")).thenReturn(user);

        // call the userService.findByUsername() method with "testuser" as argument and store the result in a variable
        User result = userService.findByUsername("testuser");

        // check that the result is not null and has the correct username
        assertEquals("testuser", result.getUsername());
    }

    @Test
    public void testSave() {
        // create a user object for testing
        User user = new User();
        user.setUsername("testuser");

        // call the userService.save() method with the user object
        userService.save(user);

        // check that the userRepository.save() method was called with the user object as argument
        Mockito.verify(userRepository).save(user);
    }

    @Test
    public void testFindAll() {
        // create a list of user objects for testing
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setUsername("user1");
        User user2 = new User();
        user2.setUsername("user2");
        userList.add(user1);
        userList.add(user2);

        // mock the userRepository.findAll() method to return the user list
        when(userRepository.findAll()).thenReturn(userList);

        // call the userService.findAll() method and store the result in a variable
        List<User> result = userService.findAll();

        // check that the result is not null and contains the correct number of users
        assertEquals(2, result.size());
        // check that the result contains the correct users
        assertEquals("user1", result.get(0).getUsername());
        assertEquals("user2", result.get(1).getUsername());
    }

    @Test
    public void testUpdate() {
        // create a user object for testing
        User user = new User();
        user.setUsername("testuser");
        user.setNickname("Test User");
        user.setRole("student");

        // mock the userRepository.findByUsername() method to return the user object when called with "testuser" as argument
        when(userRepository.findByUsername("testuser")).thenReturn(user);

        // create an updated user object
        User updatedUser = new User();
        updatedUser.setNickname("Updated User");
        updatedUser.setRole("teacher");

        // call the userService.update() method with "testuser" and the updated user object as arguments
        userService.update("testuser", updatedUser);

        // check that the userRepository.findByUsername() method was called with "testuser" as argument
        Mockito.verify(userRepository).findByUsername("testuser");

        // check that the userRepository.save() method was called with the updated user object as argument
        Mockito.verify(userRepository).save(user);

        // check that the user object has been updated correctly
        assertEquals("Updated User", user.getNickname());
        assertEquals("teacher", user.getRole());
    }

    @Test
    public void testDeleteUser() {
        // Given
        User user = new User();
        user.setUsername("testuser");
        userService.save(user);

        // When
        userService.delete("testuser");
        List<User> userList = userService.findAll();

        // Then
        assertThat(userList).doesNotContain(user);
    }


}

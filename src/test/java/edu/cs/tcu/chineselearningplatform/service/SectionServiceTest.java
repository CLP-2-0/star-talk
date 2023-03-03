package edu.cs.tcu.chineselearningplatform.service;

import static com.mongodb.internal.connection.tlschannel.util.Util.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import edu.cs.tcu.chineselearningplatform.dao.SectionRepository;
import edu.cs.tcu.chineselearningplatform.dao.UserRepository;
import edu.cs.tcu.chineselearningplatform.entity.Section;
import edu.cs.tcu.chineselearningplatform.entity.User;

public class SectionServiceTest {
    private SectionService sectionService;

    @Mock
    private SectionRepository sectionRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        sectionService = new SectionService(sectionRepository, userRepository, userService);
    }

    @Test
    public void testFindById() {
        // create a section object for testing
        Section section = new Section();
        section.setId("12345");

        // mock the sectionRepository.findById() method to return the section object when called with "12345" as argument
        when(sectionRepository.findById("12345")).thenReturn(Optional.of(section));

        // call the sectionService.findById() method with "12345" as argument and store the result in a variable
        Optional<Section> result = sectionService.findById("12345");

        // check that the result is not null and has the correct id
        assertEquals(true, result.isPresent());
        assertEquals("12345", result.get().getId());
    }

    @Test
    public void testFindStudents() {
        // create a section object for testing
        Section section = new Section();
        section.setId("12345");

        // create two user objects for testing
        User user1 = new User();
        user1.setId("111");
        User user2 = new User();
        user2.setId("222");

        // add the user objects to the section's students list
        List<User> students = new ArrayList<>();
        students.add(user1);
        students.add(user2);
        section.setStudents(students);

        // mock the sectionRepository.findById() method to return the section object when called with "12345" as argument
        when(sectionRepository.findById("12345")).thenReturn(Optional.of(section));

        // call the sectionService.findStudents() method with "12345" as argument and store the result in a variable
        List<User> result = sectionService.findStudents("12345");

        // check that the result is not null and contains the correct number of students
        assertEquals(2, result.size());
        // check that the result contains the correct students
        assertEquals("111", result.get(0).getId());
        assertEquals("222", result.get(1).getId());
    }

//    @Test
//    public void testSave() {
//        // create a section object for testing
//        Section section = new Section();
//        section.setId("12345");
//
//        // create a user object for testing
//        User user = new User();
//        user.setId("111");
//
//        // mock the userRepository.findAll() method to return a list containing the user object
//        when(userRepository.findAll()).thenReturn(List.of(user));
//
//        // call the sectionService.save() method with the section object and store the result in a variable
//        sectionService.save(section);
//
//        // check that the sectionRepository.save() method was called with the section object as argument
//        Mockito.verify(sectionRepository).save(section);
//    }

//    @Test
//    public void testFindByTeacher() {
//        // create a section object for testing
//        Section section = new Section();
//        section.setId("12345");
//
//        // create a user object for testing
//        User user = new User();
//        user.setId("111");
//        user.setRole("teacher");
//        section.setInstructor(user);
//
//        when(sectionRepository.findByTeacher(user)).thenReturn(List.of(section));
//
//        // call the sectionService.findByTeacher() method with the user object as argument and store the result in a variable
//        List<Section> result = sectionService.findByTeacher("teacher");
//
//        // check that the result is not null and contains the correct section
//        assertEquals(1, result.size());
//        assertEquals("12345", result.get(0).getId());
//    }

    @Test
    public void testAssignStudent() {
        // create a section object for testing
        Section section = new Section();
        section.setId("12345");

        // create a user object for testing
        User user = new User();
        user.setId("111");

        // mock the userRepository.findById() method to return the user object when called with "111" as argument
        when(userRepository.findById("111")).thenReturn(Optional.of(user));

        // mock the sectionRepository.findById() method to return the section object when called with "12345" as argument
        when(sectionRepository.findById("12345")).thenReturn(Optional.of(section));

        // call the sectionService.assignStudent() method with "12345" and "111" as arguments
        sectionService.assignStudent("12345", "111");

        // check that the user object was added to the section's students list
        assertTrue(section.getStudents().contains(user));
        // check that the sectionRepository.save() method was called
        Mockito.verify(sectionRepository).save(section);
    }
}



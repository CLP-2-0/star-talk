package edu.cs.tcu.chineselearningplatform.entity;

import static com.mongodb.internal.connection.tlschannel.util.Util.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
    private User user;
    private Section section1;
    private Section section2;

    @Before
    public void setUp() {
        user = new User();
        user.setId("1");
        user.setNickname("Test User");
        user.setUsername("testuser");
        user.setEmail("testuser@example.com");
        user.setPicture("http://example.com/testuser.jpg");
        user.setRole("student");

        section1 = new Section();
        section1.setId("1");
        section1.setSection("Chinese 101");

        section2 = new Section();
        section2.setId("2");
        section2.setSection("Chinese 201");
    }

    @Test
    public void testGetId() {
        assertEquals("1", user.getId());
    }

    @Test
    public void testSetId() {
        user.setId("2");
        assertEquals("2", user.getId());
    }

    @Test
    public void testGetNickname() {
        assertEquals("Test User", user.getNickname());
    }

    @Test
    public void testSetNickname() {
        user.setNickname("New User");
        assertEquals("New User", user.getNickname());
    }

    @Test
    public void testGetUsername() {
        assertEquals("testuser", user.getUsername());
    }

    @Test
    public void testSetUsername() {
        user.setUsername("newuser");
        assertEquals("newuser", user.getUsername());
    }

    @Test
    public void testGetEmail() {
        assertEquals("testuser@example.com", user.getEmail());
    }

    @Test
    public void testSetEmail() {
        user.setEmail("newuser@example.com");
        assertEquals("newuser@example.com", user.getEmail());
    }

    @Test
    public void testGetPicture() {
        assertEquals("http://example.com/testuser.jpg", user.getPicture());
    }

    @Test
    public void testSetPicture() {
        user.setPicture("http://example.com/newuser.jpg");
        assertEquals("http://example.com/newuser.jpg", user.getPicture());
    }

    @Test
    public void testGetRole() {
        assertEquals("student", user.getRole());
    }

    @Test
    public void testSetRole() {
        user.setRole("instructor");
        assertEquals("instructor", user.getRole());
    }

    @Test
    public void testAddSection() {
        user.addSection(section1);
        List<Section> sections = new ArrayList<>();
        sections.add(section1);
        assertEquals(sections, user.getSections());
        assertEquals(user, section1.getInstructor());
    }

    @Test
    public void testRemoveSection() {
        user.addSection(section1);
        user.addSection(section2);
        user.removeSection(section1);
        List<Section> sections = new ArrayList<>();
        sections.add(section2);
        assertEquals(sections, user.getSections());
        assertEquals(null, section1.getInstructor());
    }

    @Test
    public void testSetSections() {
        // create a user
        User user = new User();

        // create two sections
        Section section1 = new Section();
        Section section2 = new Section();

        // add the sections to a list
        List<Section> sections = new ArrayList<>();
        sections.add(section1);
        sections.add(section2);

        // set the list of sections for the user
        user.setSections(sections);

        // assert that the sections list for the user is equal to the original list
        assertEquals(sections, user.getSections());
    }

    @Test
    public void testGetCourses() {
        User user = new User();
        Section course1 = new Section();
        Section course2 = new Section();

        user.setCourses(course1);
        user.setCourses(course2);

        assertEquals(2, user.getCourses().size());
        assertTrue(user.getCourses().contains(course1));
        assertTrue(user.getCourses().contains(course2));
    }

    @Test
    public void testSetCourses() {
        User user = new User();
        Section course1 = new Section();
        Section course2 = new Section();

        user.setCourses(course1);
        user.setCourses(course2);

        assertEquals(2, user.getCourses().size());
        assertTrue(user.getCourses().contains(course1));
        assertTrue(user.getCourses().contains(course2));
    }

    @Test
    public void testToString() {
        String id = "123";
        String username = "testuser";
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        String expectedString = "User{id=" + id + ", username='" + username + "'}";
        assertEquals(expectedString, user.toString());
    }

}

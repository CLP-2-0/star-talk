package edu.cs.tcu.chineselearningplatform.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.assertions.Assertions.assertNotNull;
import static com.mongodb.internal.connection.tlschannel.util.Util.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserTest {

    @Test
    public void testAddSection() {
        User user = new User();
        Section section = new Section();

        user.addSection(section);

        assertEquals(1, user.getSections().size());
        assertEquals(user, section.getInstructor());
    }

    @Test
    public void testRemoveSection() {
        User user = new User();
        Section section = new Section();
        user.addSection(section);

        user.removeSection(section);

        assertEquals(0, user.getSections().size());
        Assertions.assertNull(section.getInstructor());
    }

    @Test
    public void testSetCourses() {
        User user = new User();
        Section section = new Section();

        user.setCourses(section);

        assertEquals(1, user.getCourses().size());
        assertEquals(section, user.getCourses().get(0));
    }

    @Test
    public void testSetTopicAnswer() {
        User user = new User();
        TopicAnswer topicAnswer = new TopicAnswer();
        List<TopicAnswer> topicAnswers = new ArrayList<>();
        topicAnswers.add(topicAnswer);
        user.setTopicAnswer(topicAnswers);
        List<TopicAnswer> userTopicAnswers = user.getTopicAnswer();
        assertNotNull(userTopicAnswers);
        assertEquals(1, userTopicAnswers.size());
        assertEquals(topicAnswer, userTopicAnswers.get(0));
    }

    @Test
    public void testGettersAndSetters() {
        User user = new User();
        user.setId("123");
        user.setNickname("nickname");
        user.setUsername("username");
        user.setLastname("lastname");
        user.setFirstname("firstname");
        user.setEmail("email");
        user.setEmail_verified("verified");
        user.setPicture("picture");
        user.setRole("role");

        List<Section> sections = new ArrayList<>();
        Section section = new Section();
        section.setId("sectionId");
        sections.add(section);
        user.setSections(sections);

        List<Section> courses = new ArrayList<>();
        Section course = new Section();
        course.setId("courseId");
        courses.add(course);
        user.setCourses(course);

        List<TopicAnswer> topicAnswers = new ArrayList<>();
        TopicAnswer topicAnswer = new TopicAnswer();
        topicAnswer.setId("topicAnswerId");
        topicAnswers.add(topicAnswer);
        user.setTopicAnswer(topicAnswers);

        assertEquals("123", user.getId());
        assertEquals("nickname", user.getNickname());
        assertEquals("username", user.getUsername());
        assertEquals("lastname", user.getLastname());
        assertEquals("firstname", user.getFirstname());
        assertEquals("email", user.getEmail());
        assertEquals("verified", user.getEmail_verified());
        assertEquals("picture", user.getPicture());
        assertEquals("role", user.getRole());

        assertTrue(user.getSections().contains(section));
        assertEquals(1, user.getSections().size());

        assertTrue(user.getCourses().contains(course));
        assertEquals(1, user.getCourses().size());

        assertTrue(user.getTopicAnswer().contains(topicAnswer));
        assertEquals(1, user.getTopicAnswer().size());
    }

    @Test
    void testToString() {
        User user = new User();
        user.setId("123");
        user.setUsername("johnDoe");

        String expectedString = "User{id=123, username='johnDoe'}";
        String actualString = user.toString();

        assertEquals(expectedString, actualString);
    }

}

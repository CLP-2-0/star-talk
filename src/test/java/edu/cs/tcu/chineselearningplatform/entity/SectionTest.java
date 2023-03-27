package edu.cs.tcu.chineselearningplatform.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.cs.tcu.chineselearningplatform.entity.Section;
import edu.cs.tcu.chineselearningplatform.entity.User;

public class SectionTest {

    private Section section;

    @BeforeEach
    public void setUp() {
        section = new Section();
    }

    @Test
    public void testSetAndGetId() {
        String id = "123";
        section.setId(id);
        assertEquals(id, section.getId());
    }

    @Test
    public void testSetAndGetSection() {
        String sectionName = "Section 1";
        section.setSection(sectionName);
        assertEquals(sectionName, section.getSection());
    }

    @Test
    public void testSetAndGetInstructor() {
        User instructor = new User();
        instructor.setUsername("JohnDoe");
        section.setInstructor(instructor);
        assertEquals(instructor, section.getInstructor());
    }

    @Test
    public void testSetAndGetStudents() {
        User student1 = new User();
        student1.setUsername("Alice");
        User student2 = new User();
        student2.setUsername("Bob");

        section.addStudent(student1);
        section.addStudent(student2);

        List<User> students = section.getStudents();

        assertEquals(2, students.size());
        assertTrue(students.contains(student1));
        assertTrue(students.contains(student2));
    }

    @Test
    public void testSetStudents() {
        // create a new section and user objects
        Section section = new Section();
        User user1 = new User();
        user1.setUsername("Alice");
        User user2 = new User();
        user2.setUsername("Bob");
        List<User> students = new ArrayList<>();
        students.add(user1);
        students.add(user2);

        // set the students property of the section
        section.setStudents(students);

        // check that the students property was set correctly
        assertEquals(students, section.getStudents());
    }

    @Test
    public void testAddAndRemoveStudent() {
        User student1 = new User();
        student1.setUsername("Alice");
        User student2 = new User();
        student2.setUsername("Bob");

        section.addStudent(student1);
        section.addStudent(student2);

        section.removeStudent(student1);

        List<User> students = section.getStudents();
        assertEquals(1, students.size());
        assertFalse(students.contains(student1));
        assertTrue(students.contains(student2));
    }

    @Test
    public void testSetAndGetHomeworkMap() {
        Map<String, String> homeworkMap = new HashMap<>();
        homeworkMap.put("Lesson 1", "Homework 1");
        homeworkMap.put("Lesson 2", "Homework 2");

        section.setHomeworkMap(homeworkMap);

        assertEquals(homeworkMap, section.getHomeworkMap());
    }

    @Test
    public void testAddHomework() {
        String lesson = "Lesson 1";
        String homework = "Homework 1";

        String oldHomework = section.addHomework(lesson, homework);
        assertNull(oldHomework);

        oldHomework = section.addHomework(lesson, "Updated Homework 1");
        assertEquals(homework, oldHomework);

        Map<String, String> expectedMap = new HashMap<>();
        expectedMap.put(lesson, "Updated Homework 1");

        assertEquals(expectedMap, section.getHomeworkMap());
    }

    @Test
    public void testSetAndGetExamMap() {
        Map<String, String> examMap = new HashMap<>();
        examMap.put("Lesson 1", "Exam 1");
        examMap.put("Lesson 2", "Exam 2");

        section.setExamMap(examMap);

        assertEquals(examMap, section.getExamMap());
    }

    @Test
    public void testAddExam() {
        section.addExam("Lesson 1", "Exam 1");
        section.addExam("Lesson 2", "Exam 2");
        section.addExam("Lesson 3", "Exam 3");

        Map<String, String> examMap = section.getExamMap();
        assertNotNull(examMap);
        assertEquals(3, examMap.size());

        assertEquals("Exam 1", examMap.get("Lesson 1"));
        assertEquals("Exam 2", examMap.get("Lesson 2"));
        assertEquals("Exam 3", examMap.get("Lesson 3"));

        String oldExam = section.addExam("Lesson 2", "New Exam 2");
        assertEquals("Exam 2", oldExam);
        assertEquals("New Exam 2", examMap.get("Lesson 2"));
    }

    @Test
    public void testSetExamMap() {
        Map<String, String> examMap = new HashMap<>();
        examMap.put("Lesson 1", "Exam 1");
        examMap.put("Lesson 2", "Exam 2");
        examMap.put("Lesson 3", "Exam 3");

        section.setExamMap(examMap);

        Map<String, String> retrievedExamMap = section.getExamMap();
        assertNotNull(retrievedExamMap);
        assertEquals(3, retrievedExamMap.size());

        assertEquals("Exam 1", retrievedExamMap.get("Lesson 1"));
        assertEquals("Exam 2", retrievedExamMap.get("Lesson 2"));
        assertEquals("Exam 3", retrievedExamMap.get("Lesson 3"));

        examMap.put("Lesson 4", "Exam 4");
        section.setExamMap(examMap);

        retrievedExamMap = section.getExamMap();
        assertNotNull(retrievedExamMap);
        assertEquals(4, retrievedExamMap.size());

        assertEquals("Exam 1", retrievedExamMap.get("Lesson 1"));
        assertEquals("Exam 2", retrievedExamMap.get("Lesson 2"));
        assertEquals("Exam 3", retrievedExamMap.get("Lesson 3"));
        assertEquals("Exam 4", retrievedExamMap.get("Lesson 4"));
    }
}

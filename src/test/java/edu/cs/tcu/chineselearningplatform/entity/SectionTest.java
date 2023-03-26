package edu.cs.tcu.chineselearningplatform.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class SectionTest {

    @InjectMocks
    private Section section;

    @Test
    public void testGetId() {
        String id = "123";
        section.setId(id);
        assertEquals(id, section.getId());
    }

    @Test
    public void testGetInstructor() {
        User instructor = new User();
        section.setInstructor(instructor);
        assertNotNull(section.getInstructor());
    }

    @Test
    public void testGetHomeworkMap() {
        Map<String, String> homeworkMap = new HashMap<>();
        section.setHomeworkMap(homeworkMap);
        assertNotNull(section.getHomeworkMap());
    }

    @Test
    public void testAddHomework() {
        String lesson = "lesson1";
        String hw = "homework1";
        String oldHw = section.addHomework(lesson, hw);
        assertEquals(hw, section.getHomeworkMap().get(lesson));
        assertEquals(null, oldHw);

        String newHw = "homework2";
        oldHw = section.addHomework(lesson, newHw);
        assertEquals(newHw, section.getHomeworkMap().get(lesson));
        assertEquals(hw, oldHw);
    }

    @Test
    public void testGetSection() {
        String sectionName = "section1";
        section.setSection(sectionName);
        assertEquals(sectionName, section.getSection());
    }

    @Test
    public void testGetStudents() {
        List<User> students = new ArrayList<>();
        section.setStudents(students);
        assertNotNull(section.getStudents());
    }

    @Test
    public void testSetId() {
        String id = "123456789";
        section.setId(id);
        assertEquals(id, section.getId());
    }

    @Test
    public void testSetInstructor() {
        User instructor = new User();
        section.setInstructor(instructor);
        assertEquals(instructor, section.getInstructor());
    }

    @Test
    public void testSetHomeworkMap() {
        Map<String, String> homeworkMap = new HashMap<>();
        homeworkMap.put("Lesson1", "Homework1");
        section.setHomeworkMap(homeworkMap);
        assertEquals(homeworkMap, section.getHomeworkMap());
    }

    @Test
    public void testSetSection() {
        String sectionName = "Section1";
        section.setSection(sectionName);
        assertEquals(sectionName, section.getSection());
    }

    @Test
    public void testSetStudents() {
        List<User> students = new ArrayList<>();
        User student1 = new User();
        User student2 = new User();
        students.add(student1);
        students.add(student2);
        section.setStudents(students);
        assertEquals(students, section.getStudents());
    }

    @Test
    public void testAddStudent() {
        User student = new User();
        section.addStudent(student);
        assertEquals(1, section.getStudents().size());
    }

    @Test
    public void testRemoveStudent() {
        User student = new User();
        section.addStudent(student);
        section.removeStudent(student);
        assertEquals(0, section.getStudents().size());
    }


}

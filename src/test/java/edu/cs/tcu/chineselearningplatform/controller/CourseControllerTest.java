package edu.cs.tcu.chineselearningplatform.controller;

import edu.cs.tcu.chineselearningplatform.entity.Course;
import edu.cs.tcu.chineselearningplatform.entity.User;
import edu.cs.tcu.chineselearningplatform.entity.util.Result;
import edu.cs.tcu.chineselearningplatform.service.CourseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CourseControllerTest {

    @Mock
    CourseService courseService;
    @InjectMocks
    CourseController courseController;

    @Test
    void testFindById() {
        Course course1 = new Course();
        course1.setSection("Intro to Programming");

        when(courseService.findByObjectId("testCourse1"))
                .thenReturn(course1);

        Result r = courseController.findById("testCourse1");
        assertEquals(course1, r.getData());
    }

    @Test
    void testFindStudents() {
        List<User> students = new ArrayList<>();
        students.add(new User("Kelly Hatman"));
        students.add(new User("Justin Monash"));
        Course course1 = new Course();
        course1.setSection("Intro to Programming");
        course1.setStudents(students);

        when(courseService.findStudents("testCourse1"))
                .thenReturn(students);

        Result r = courseController.findStudents("testCourse1");
        assertEquals(course1.getStudents(), r.getData());
    }
}
package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.CourseRepository;
import edu.cs.tcu.chineselearningplatform.entity.Course;
import edu.cs.tcu.chineselearningplatform.entity.User;
import org.bson.types.ObjectId;
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
class CourseServiceTest {
    @Mock
    CourseRepository courseRepository;

    @InjectMocks
    CourseService courseService;

    @Test
    void findByObjectId() {
        List<User> students = new ArrayList<>();
        students.add(new User("Kelly Hatman"));
        students.add(new User("Justin Monash"));
        Course course1 = new Course();
        course1.setSection("Intro to Programming");
        course1.setStudents(students);
        when(courseRepository.findByObjectId(new ObjectId("6342139d1d62b17c341a49b1"))).thenReturn(course1);

        Course c1 = courseService.findByObjectId("6342139d1d62b17c341a49b1");

        assertEquals("Intro to Programming",c1.getSection());
    }

    @Test
    void findStudents() {
        List<User> students = new ArrayList<>();
        students.add(new User("Kelly Hatman"));
        students.add(new User("Justin Monash"));
        Course course1 = new Course();
        course1.setSection("Intro to Programming");
        course1.setStudents(students);
        when(courseRepository.findByObjectId(new ObjectId("6342139d1d62b17c341a49b1"))).thenReturn(course1);

        List<User> students1 = courseService.findStudents("6342139d1d62b17c341a49b1");

        assertEquals(2,students1.size());
    }
}
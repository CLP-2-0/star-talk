//package edu.cs.tcu.chineselearningplatform.controller;
//
//import edu.cs.tcu.chineselearningplatform.entity.Section;
//import edu.cs.tcu.chineselearningplatform.entity.User;
//import edu.cs.tcu.chineselearningplatform.entity.util.Result;
//import edu.cs.tcu.chineselearningplatform.service.SectionService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class SectionControllerTest {
//
//    @Mock
//    SectionService sectionService;
//    @InjectMocks
//    SectionController sectionController;
//
//    @Test
//    void testFindById() {
//        Section section1 = new Section();
//        section1.setSection("Intro to Programming");
//
//        when(sectionService.findById("testCourse1"))
//                .thenReturn(Optional.of(section1));
//
//        Result r = sectionController.findById("testCourse1");
//        assertEquals(section1, r.getData());
//    }
//
//    @Test
//    void testFindStudents() {
//        List<User> students = new ArrayList<>();
//        students.add(new User("Kelly Hatman"));
//        students.add(new User("Justin Monash"));
//        Section section1 = new Section();
//        section1.setSection("Intro to Programming");
//        section1.setStudents(students);
//
//        when(sectionService.findStudents("testCourse1"))
//                .thenReturn(students);
//
//        Result r = sectionController.findStudents("testCourse1");
//        assertEquals(section1.getStudents(), r.getData());
//    }
//}
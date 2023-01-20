//package edu.cs.tcu.chineselearningplatform.service;
//
//import edu.cs.tcu.chineselearningplatform.dao.SectionRepository;
//import edu.cs.tcu.chineselearningplatform.entity.Section;
//import edu.cs.tcu.chineselearningplatform.entity.User;
//import org.bson.types.ObjectId;
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
//class SectionServiceTest {
//    @Mock
//    SectionRepository sectionRepository;
//
//    @InjectMocks
//    SectionService sectionService;
//
//    @Test
//    void findByObjectId() {
//        List<User> students = new ArrayList<>();
//        students.add(new User("Kelly Hatman"));
//        students.add(new User("Justin Monash"));
//        Section section1 = new Section();
//        section1.setSection("Intro to Programming");
//        section1.setStudents(students);
//        when(sectionRepository.findById("6342139d1d62b17c341a49b1")).thenReturn(Optional.of(section1));
//
//        Optional<Section> c1 = sectionService.findById("6342139d1d62b17c341a49b1");
//
//        assertEquals("Intro to Programming",c1.get().getSection());
//    }
//
//    @Test
//    void findStudents() {
//        List<User> students = new ArrayList<>();
//        students.add(new User("Kelly Hatman"));
//        students.add(new User("Justin Monash"));
//        Section section1 = new Section();
//        section1.setSection("Intro to Programming");
//        section1.setStudents(students);
//        when(sectionRepository.findByObjectId(new ObjectId("6342139d1d62b17c341a49b1"))).thenReturn(section1);
//
//        List<User> students1 = sectionService.findStudents("6342139d1d62b17c341a49b1");
//
//        assertEquals(2,students1.size());
//    }
//}
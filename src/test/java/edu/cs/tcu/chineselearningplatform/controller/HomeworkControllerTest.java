package edu.cs.tcu.chineselearningplatform.controller;
import edu.cs.tcu.chineselearningplatform.entity.Homework;
import edu.cs.tcu.chineselearningplatform.entity.Lesson;
import edu.cs.tcu.chineselearningplatform.entity.Section;
import edu.cs.tcu.chineselearningplatform.entity.util.Result;
import edu.cs.tcu.chineselearningplatform.service.HomeworkService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HomeworkControllerTest {
    @Mock
    HomeworkService homeworkService;
    @InjectMocks
    HomeworkController homeworkController;

    List<Homework> list;

    @Test
    void testFindById() {
        Homework homework1 = new Homework();
//       homework1.setType("student");
//       homework1.setAttachment("hw1 updated");

        when(homeworkService.findById("634c8d1356eee1d489ecf66c"))
                .thenReturn(homework1);

        Result r = homeworkController.findById("634c8d1356eee1d489ecf66c");
        assertEquals(homework1, r.getData());
    }


    @Test
    void findHomework() {
        Homework homework1 = new Homework();
        Section section1 = new Section();
        Lesson lesson1 = new Lesson();

        when(homeworkService.findHomework("f0162d75-8803-4975-8fa2-8659e533fafd", "4"))
                .thenReturn(homework1);

        Result r = homeworkController.findHomework("f0162d75-8803-4975-8fa2-8659e533fafd", "4");
        assertEquals(homework1, r.getData());

    }


    @Test
    void findAll() {
        Homework homework1 = new Homework();


        Homework homework2 = new Homework();


        list = new ArrayList<>();
        list.add(homework1);
        list.add(homework2);

        when(homeworkService.findAll()).thenReturn(list);

        assertEquals(2, homeworkService.findAll().size());
    }

    @Test
    void delete() {
        Homework homework1 = new Homework();
        Section section1 = new Section();
        homework1.setSection(section1);

        doNothing().when(homeworkService).delete(isA(String.class));
        homeworkService.delete("63dd48201c683a40d6ef547c");

        verify(homeworkService, times(1)).delete("63dd48201c683a40d6ef547c");
    }
}







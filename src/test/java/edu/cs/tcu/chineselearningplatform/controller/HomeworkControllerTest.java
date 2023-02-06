package edu.cs.tcu.chineselearningplatform.controller;
import edu.cs.tcu.chineselearningplatform.entity.Homework;
import edu.cs.tcu.chineselearningplatform.entity.util.Result;
import edu.cs.tcu.chineselearningplatform.service.HomeworkService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HomeworkControllerTest {
    @Mock
    HomeworkService homeworkService;
    @InjectMocks
    HomeworkController homeworkController;

    @Test
    void testFindById() {
        Homework homework1 = new Homework();
        homework1.setType("student");
        homework1.setAttachment("hw1 updated");

        when(homeworkService.findById("634c8d1356eee1d489ecf66c"))
                .thenReturn(homework1);

        Result r = homeworkController.findById("634c8d1356eee1d489ecf66c");
        assertEquals(homework1, r.getData());
    }

//    @Test
//    void testFindBySectionId() {
//        Homework homework1 = new Homework();
//        homework1.setSectionId("40");
//        homework1.setUserId("04");
//        homework1.setType("student");
//        homework1.setAttachment("hw1 updated");
//        homework1.setQuestionsId("01");
//
////        when(homeworkService.findAllBySection("40"))
////                .thenReturn(homework1);
//    }
}

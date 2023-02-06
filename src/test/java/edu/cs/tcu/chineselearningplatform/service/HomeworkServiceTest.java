package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.HomeworkRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class HomeworkServiceTest {

    @Mock
    HomeworkRepository homeworkRepository;
    @InjectMocks
    HomeworkService homeworkService;

//    @Test
//    void testFindById() {
//        Homework homework1 = new Homework();
//        homework1.setSectionId("40");
//        homework1.setUserId("04");
//        homework1.setType("student");
//        homework1.setAttachment("hw1 updated");
//        homework1.setQuestionsId("01");
//
//        when(homeworkRepository.findByObjectId(any(ObjectId.class))).thenReturn(homework1);
//
//        Homework res = homeworkService.findByObjectId("634c8d1356eee1d489ecf66c");
//
//        assertEquals(homework1.getSectionId(), res.getSectionId());
//    }
}

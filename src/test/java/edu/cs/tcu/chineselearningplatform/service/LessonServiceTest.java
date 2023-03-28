package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.GradedQuestionRepository;
import edu.cs.tcu.chineselearningplatform.dao.HomeworkRepository;
import edu.cs.tcu.chineselearningplatform.dao.LessonRepository;
import edu.cs.tcu.chineselearningplatform.entity.GradedQuestion;
import edu.cs.tcu.chineselearningplatform.entity.Homework;
import edu.cs.tcu.chineselearningplatform.entity.Lesson;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
public class LessonServiceTest {

    @Mock
    LessonRepository lessonRepository;

    @Mock
    GradedQuestionRepository gradedQuestionRepository;

    @Mock
    HomeworkRepository homeworkRepository;

    @InjectMocks
    private LessonService lessonService;

    private Lesson testLesson;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        testLesson = new Lesson();
        testLesson.setId("1");
        testLesson.setTitle("Test Lesson");
        testLesson.setContent("Test Content");
    }

    @Test
    void findByIdTest() {
        when(lessonRepository.findById("1")).thenReturn(Optional.of(testLesson));
        Lesson foundLesson = lessonService.findById("1");
        assertEquals("Test Lesson", foundLesson.getTitle());
    }

    @Test
    void saveTest() {
        lessonService.save(testLesson);
        verify(lessonRepository, times(1)).save(testLesson);
    }

    @Test
    void findAllTest() {
        List<Lesson> testLessonList = Arrays.asList(testLesson);
        when(lessonRepository.findAll()).thenReturn(testLessonList);
        List<Lesson> foundLessonList = lessonService.findAll();
        assertEquals(1, foundLessonList.size());
    }

    @Test
    void updateTest() {
        Lesson updatedLesson = new Lesson();
        updatedLesson.setId("1");
        updatedLesson.setTitle("Updated Test Lesson");
        updatedLesson.setContent("Updated Test Content");
        when(lessonRepository.findById("1")).thenReturn(Optional.of(testLesson));
        lessonService.update("1", updatedLesson);
        verify(lessonRepository, times(1)).save(testLesson);
        assertEquals("Updated Test Lesson", testLesson.getTitle());
    }

    @Test
    void deleteTest() {
        lessonService.delete("1");
        verify(lessonRepository, times(1)).deleteById("1");
    }

//    @Test
//    void savePredefinedHomeworkTest() {
//        GradedQuestion question1 = new GradedQuestion();
//        question1.setId("1");
//
//
//        GradedQuestion question2 = new GradedQuestion();
//        question2.setId("2");
//
//        List<GradedQuestion> questionList = Arrays.asList(question1, question2);
//
//        when(gradedQuestionRepository.save(question1)).thenReturn(question1);
//        when(gradedQuestionRepository.save(question2)).thenReturn(question2);
//
//        Homework hw = new Homework();
//        hw.setQuestionList(questionList);
//
//        when(homeworkRepository.save(hw)).thenReturn(hw);
//
//        when(lessonRepository.findById("1")).thenReturn(Optional.of(testLesson));
//
//        lessonService.savePredefinedHomework("1", questionList);
//
//        verify(gradedQuestionRepository, times(2)).save(any(GradedQuestion.class));
//        verify(homeworkRepository, times(1)).save(hw);
//
//        assertNotNull(testLesson.getPredefined());
//        assertEquals(hw.getQuestionList().size(), testLesson.getPredefined().getQuestionList().size());
//    }
}

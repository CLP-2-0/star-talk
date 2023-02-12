package edu.cs.tcu.chineselearningplatform.controller;


import edu.cs.tcu.chineselearningplatform.dao.QuestionRepository;
import edu.cs.tcu.chineselearningplatform.entity.Lesson;
import edu.cs.tcu.chineselearningplatform.entity.Question;
import edu.cs.tcu.chineselearningplatform.entity.util.Result;
import edu.cs.tcu.chineselearningplatform.service.LessonService;
import edu.cs.tcu.chineselearningplatform.service.QuestionService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static java.util.List.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class QuestionControllerTest {

    @Mock
    QuestionService questionService;
    @InjectMocks
    QuestionController questionController;

    List<Question> list;

    @Test
    void testFindById() {
        Question question1 = new Question();
        question1.setQuestion("Q1");
        question1.setAnswer("A1");

        when(questionService.findById("6342139d1d62b17c341a49b1"))
                .thenReturn(question1);

        Result r = questionController.findById("6342139d1d62b17c341a49b1");
        assertEquals(question1, r.getData());
    }

    @Test
    void save() {
        Question question1 = new Question();
        question1.setQuestion("Q1");
        question1.setAnswer("A1");

        questionService.save(question1, "100");

        verify(questionService, times(1)).save(question1, "100");
    }

    @Test
    void deleteById() {
        Question question1 = new Question();
        question1.setQuestion("Q1");
        question1.setAnswer("A1");

        doNothing().when(questionService).delete(isA(String.class));
        questionService.delete("63bd7c2684ebc03a6ff95122");

        verify(questionService, times(1)).delete("63bd7c2684ebc03a6ff95122");
    }

//    @Test
//    void findAllByLesson() {
//        Question question1 = new Question();
//        Lesson lesson1 = new Lesson();
//        question1.setLesson(lesson1);
//        Question question2 = new Question();
//        question1.setLesson(lesson1);
//
//        list = new ArrayList<>();
//        list.add(question1);
//        list.add(question2);
//
//        when(questionService.findAllByLesson("1"))
//                .thenReturn(list);
//
//        Result r = questionController.findAllByLesson("1");
//        assertEquals(question1, r.getData());
//    }
    }

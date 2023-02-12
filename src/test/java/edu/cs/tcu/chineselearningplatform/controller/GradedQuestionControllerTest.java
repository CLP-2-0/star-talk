package edu.cs.tcu.chineselearningplatform.controller;

import edu.cs.tcu.chineselearningplatform.entity.Answer;
import edu.cs.tcu.chineselearningplatform.entity.GradedQuestion;
import edu.cs.tcu.chineselearningplatform.service.GradedQuestionService;
import edu.cs.tcu.chineselearningplatform.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class GradedQuestionControllerTest {

    @Mock
    GradedQuestionService gradedQuestionService;
    @InjectMocks
    GradedQuestionController gradedQuestionController;

//    @Test
//    void save() {
//        GradedQuestion gradedQuestion1 = new GradedQuestion();
//        Answer answer1 = new Answer();
//
//
//        gradedQuestionService.saveAnswerToAQuestion(answer1, "username", "1");
//
//        verify(gradedQuestionService, times(1)).saveAnswerToAQuestion(answer1, "username","1");
//
//
//    }

    @Test
    void findAllAnswers() {

    }
}
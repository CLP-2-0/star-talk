package edu.cs.tcu.chineselearningplatform.entity;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GradedQuestionTest {
    private GradedQuestion gradedQuestion;
    private Question question;


    @BeforeEach
    public void setUp() {
        question = new Question();
        question.setId("1");




        gradedQuestion = new GradedQuestion();
        gradedQuestion.setId("1");
        gradedQuestion.setQuestion(question);
        gradedQuestion.setPoint(5);
    }

    @Test
    public void testGetId() {
        Assertions.assertEquals("1", gradedQuestion.getId());
    }

    @Test
    public void testSetId() {
        gradedQuestion.setId("2");
        Assertions.assertEquals("2", gradedQuestion.getId());
    }

    @Test
    public void testGetQuestion() {
        Assertions.assertEquals(question, gradedQuestion.getQuestion());
    }

    @Test
    public void testSetQuestion() {
        Question newQuestion = new Question();
        newQuestion.setId("2");
        gradedQuestion.setQuestion(newQuestion);
        Assertions.assertEquals(newQuestion, gradedQuestion.getQuestion());
    }

    @Test
    public void testGetPoint() {
        Assertions.assertEquals(5, gradedQuestion.getPoint());
    }

    @Test
    public void testSetPoint() {
        gradedQuestion.setPoint(10);
        Assertions.assertEquals(10, gradedQuestion.getPoint());
    }

    @Test
    public void testGetAnswerList() {
        GradedQuestion gradedQuestion1 = new GradedQuestion();
        List<Answer> answerList = new ArrayList<>();
        Answer answer = new Answer();
        answerList.add(answer);
        gradedQuestion1.setAnswerList(answerList);
        assertEquals(answerList, gradedQuestion1.getAnswerList());
    }

    @Test
    public void testSetAnswerList() {
        GradedQuestion gradedQuestion1 = new GradedQuestion();
        List<Answer> answerList = new ArrayList<>();
        Answer answer = new Answer();
        answerList.add(answer);
        gradedQuestion1.setAnswerList(answerList);
        assertEquals(answerList, gradedQuestion1.getAnswerList());
    }

    @Test
    public void testAddAnswer() {
        Answer answer = new Answer();
        answer.setId("1");
        answer.setType("Text");

        gradedQuestion.addAnswer(answer);

        List<Answer> expectedAnswers = new ArrayList<>();
        expectedAnswers.add(answer);

        Assertions.assertEquals(expectedAnswers, gradedQuestion.getAnswerList());

    }

}

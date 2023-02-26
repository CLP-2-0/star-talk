package edu.cs.tcu.chineselearningplatform.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

public class GradedQuestionTest {
    private GradedQuestion gradedQuestion;
    private Question question;
    private Map<String, String> answersMap;

    @BeforeEach
    public void setUp() {
        question = new Question();
        question.setId("1");


        answersMap = new HashMap<>();
        answersMap.put("12345-username", "answerId");

        gradedQuestion = new GradedQuestion();
        gradedQuestion.setId("1");
        gradedQuestion.setQuestion(question);
        gradedQuestion.setPoint(5);
        gradedQuestion.setAnswersMap(answersMap);
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
    public void testGetAnswersMap() {
        Assertions.assertEquals(answersMap, gradedQuestion.getAnswersMap());
    }

    @Test
    public void testSetAnswersMap() {
        Map<String, String> newAnswersMap = new HashMap<>();
        newAnswersMap.put("67890-username", "newAnswerId");
        gradedQuestion.setAnswersMap(newAnswersMap);
        Assertions.assertEquals(newAnswersMap, gradedQuestion.getAnswersMap());
    }

    @Test
    public void testAddAnswer() {
        gradedQuestion.addAnswer("testUser", "testAnswerId");
        Assertions.assertTrue(gradedQuestion.getAnswersMap().containsValue("testAnswerId"));
    }
}

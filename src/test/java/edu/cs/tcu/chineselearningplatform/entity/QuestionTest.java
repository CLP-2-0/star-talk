package edu.cs.tcu.chineselearningplatform.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuestionTest {
    @Test
    public void testGetId() {
        Question question = new Question();
        question.setId("12345");
        Assertions.assertEquals("12345", question.getId());
    }

    @Test
    public void testSetId() {
        Question question = new Question();
        question.setId("12345");
        Assertions.assertEquals("12345", question.getId());
    }

    @Test
    public void testGetQuestion() {
        Question question = new Question();
        question.setQuestion("What is your name?");
        Assertions.assertEquals("What is your name?", question.getQuestion());
    }

    @Test
    public void testSetQuestion() {
        Question question = new Question();
        question.setQuestion("What is your name?");
        Assertions.assertEquals("What is your name?", question.getQuestion());
    }

    @Test
    public void testGetAnswer() {
        Question question = new Question();
        question.setAnswer("My name is John.");
        Assertions.assertEquals("My name is John.", question.getAnswer());
    }

    @Test
    public void testSetAnswer() {
        Question question = new Question();
        question.setAnswer("My name is John.");
        Assertions.assertEquals("My name is John.", question.getAnswer());
    }

    @Test
    public void testGetLesson() {
        Question question = new Question();
        Lesson lesson = new Lesson();
        lesson.setId("12345");
        question.setLesson(lesson);
        Assertions.assertEquals(lesson, question.getLesson());
    }

    @Test
    public void testSetLesson() {
        Question question = new Question();
        Lesson lesson = new Lesson();
        lesson.setId("12345");
        question.setLesson(lesson);
        Assertions.assertEquals(lesson, question.getLesson());
    }
}

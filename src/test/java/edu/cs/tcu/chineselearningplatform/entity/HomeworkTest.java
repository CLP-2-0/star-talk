package edu.cs.tcu.chineselearningplatform.entity;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class HomeworkTest {

    @Test
    public void testGetId() {
        Homework homework = new Homework();
        homework.setId("12345");
        assertEquals("12345", homework.getId());
    }

    @Test
    public void testSetId() {
        Homework homework = new Homework();
        homework.setId("12345");
        assertEquals("12345", homework.getId());
    }

    @Test
    public void testGetSection() {
        Homework homework = new Homework();
        Section section = new Section();
        homework.setSection(section);
        assertEquals(section, homework.getSection());
    }

    @Test
    public void testSetSection() {
        Homework homework = new Homework();
        Section section = new Section();
        homework.setSection(section);
        assertEquals(section, homework.getSection());
    }

    @Test
    public void testGetLesson() {
        Homework homework = new Homework();
        Lesson lesson = new Lesson();
        homework.setLesson(lesson);
        assertEquals(lesson, homework.getLesson());
    }

    @Test
    public void testSetLesson() {
        Homework homework = new Homework();
        Lesson lesson = new Lesson();
        homework.setLesson(lesson);
        assertEquals(lesson, homework.getLesson());
    }

    @Test
    public void testGetPoints() {
        Homework homework = new Homework();
        List<Integer> points = new ArrayList<>();
        points.add(10);
        homework.setGrade(points);
        assertEquals(points, homework.getPoints());
    }

    @Test
    public void testSetPoints() {
        Homework homework = new Homework();
        List<Integer> points = new ArrayList<>();
        points.add(10);
        homework.setGrade(points);
        assertEquals(points, homework.getPoints());
    }

    @Test
    public void testGetQuestionList() {
        Homework homework = new Homework();
        List<GradedQuestion> questionList = new ArrayList<>();
        GradedQuestion gradedQuestion = new GradedQuestion();
        questionList.add(gradedQuestion);
        homework.setQuestionList(questionList);
        assertEquals(questionList, homework.getQuestionList());
    }

    @Test
    public void testSetQuestionList() {
        Homework homework = new Homework();
        List<GradedQuestion> questionList = new ArrayList<>();
        GradedQuestion gradedQuestion = new GradedQuestion();
        questionList.add(gradedQuestion);
        homework.setQuestionList(questionList);
        assertEquals(questionList, homework.getQuestionList());
    }


}

package edu.cs.tcu.chineselearningplatform.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class HomeworkTest {

    @Test
    void testHomeworkGetterSetter() {
        Homework homework = new Homework();
        homework.setId("1");
        homework.setTime("10:00 AM");

        Section section = new Section();
        section.setId("1");
        homework.setSection(section);

        Lesson lesson = new Lesson();
        lesson.setId("1");
        lesson.setTitle("Lesson 1");
        homework.setLesson(lesson);

        List<GradedQuestion> questionList = new ArrayList<>();
        GradedQuestion question1 = new GradedQuestion();
        question1.setId("1");
        questionList.add(question1);

        GradedQuestion question2 = new GradedQuestion();
        question2.setId("2");
        questionList.add(question2);

        homework.setQuestionList(questionList);

        assertEquals("1", homework.getId());
        assertEquals("10:00 AM", homework.getTime());
        assertEquals(section, homework.getSection());
        assertEquals(lesson, homework.getLesson());
        assertEquals(questionList, homework.getQuestionList());
    }
}

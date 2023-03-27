package edu.cs.tcu.chineselearningplatform.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExamAnswerTest {

    @Test
    public void testSetAndGetId() {
        ExamAnswer examAnswer = new ExamAnswer();
        examAnswer.setId("1");
        Assertions.assertEquals("1", examAnswer.getId());
    }

    @Test
    public void testSetAndGetAnswer() {
        ExamAnswer examAnswer = new ExamAnswer();
        Answer answer = new Answer();
        examAnswer.setAnswer(answer);
        Assertions.assertEquals(answer, examAnswer.getAnswer());
    }

    @Test
    public void testSetAndGetGrade() {
        ExamAnswer examAnswer = new ExamAnswer();
        examAnswer.setGrade(80);
        Assertions.assertEquals(80, examAnswer.getGrade());
    }

    @Test
    public void testSetAndGetStudent() {
        ExamAnswer examAnswer = new ExamAnswer();
        examAnswer.setStudent("John");
        Assertions.assertEquals("John", examAnswer.getStudent());
    }
}

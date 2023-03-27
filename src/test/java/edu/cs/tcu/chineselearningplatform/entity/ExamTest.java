package edu.cs.tcu.chineselearningplatform.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import edu.cs.tcu.chineselearningplatform.entity.Exam;
import edu.cs.tcu.chineselearningplatform.entity.ExamAnswer;

public class ExamTest {
    private Exam exam;

    @BeforeEach
    public void setUp() {
        exam = new Exam();
    }

    @Test
    public void testSetAndGetId() {
        String id = "123";
        exam.setId(id);
        assertEquals(id, exam.getId());
    }

    @Test
    public void testSetAndGetStartTime() {
        String startTime = "10:00";
        exam.setStartTime(startTime);
        assertEquals(startTime, exam.getStartTime());
    }

    @Test
    public void testSetAndGetStartDate() {
        String startDate = "2022-03-31";
        exam.setStartDate(startDate);
        assertEquals(startDate, exam.getStartDate());
    }

    @Test
    public void testSetAndGetSubmissions() {
        List<List<ExamAnswer>> submissions = new ArrayList<>();
        submissions.add(new ArrayList<>());
        exam.setSubmissions(submissions);
        assertEquals(submissions, exam.getSubmissions());
    }

    @Test
    public void testAddAndRemoveSubmission() {
        List<ExamAnswer> submission = new ArrayList<>();
        exam.addSubmission(submission);
        assertTrue(exam.getSubmissions().contains(submission));

        exam.removeSubmission(submission);
        assertFalse(exam.getSubmissions().contains(submission));
    }

    @Test
    public void testSetAndGetGradeMap() throws JsonProcessingException {
        HashMap<String, Integer> gradeMap = new HashMap<>();
        gradeMap.put("user1", 90);
        exam.setGradeMap(gradeMap);
        assertEquals(gradeMap, exam.getGradeHashMap());
        assertEquals("{\"user1\":90}", exam.getGradeMap());
    }

    @Test
    public void testAddToGradeMap() throws JsonProcessingException {
        exam.addToGradeMap("user1", 90);
        assertTrue(exam.getGradeHashMap().containsKey("user1"));
        assertEquals("{\"user1\":90}", exam.getGradeMap());
    }
}

package edu.cs.tcu.chineselearningplatform.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Document("Exam")
public class Exam implements Serializable {
    @Id
    private String id;
    private String startTime;
    private String startDate;
    private String length;
    private List<List<ExamAnswer>> submissions = new ArrayList<>();
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private HashMap<String, Integer> gradeMap = new HashMap<>();
    @DBRef
    private Homework exam;
    private List<String> takenList = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public List<List<ExamAnswer>> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<List<ExamAnswer>> submissions) {
        this.submissions = submissions;
    }

    public void addSubmission(List<ExamAnswer> submission) {
        submissions.add(submission);
    }

    public void removeSubmission(List<ExamAnswer> submission) {
        submissions.remove(submission);
    }

    public String getGradeMap() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(gradeMap);
        return json;
    }

    public HashMap<String, Integer> getGradeHashMap() {
        return gradeMap;
    }

    public void setGradeMap(HashMap<String, Integer> gradeMap) {
        this.gradeMap = gradeMap;
    }

    public void addToGradeMap(String username, Integer grade) throws JsonProcessingException {
        gradeMap.put(username, grade);
        System.out.println(gradeMap);
        System.out.println(getGradeMap());
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public Homework getExam() {
        return exam;
    }

    public void setExam(Homework exam) {
        this.exam = exam;
    }

    public List<String> getTakenList() {
        return takenList;
    }

    public void setTakenList(List<String> takenList) {
        this.takenList = takenList;
    }

    public void addTaken(String username) {
        takenList.add(username);
    }
}

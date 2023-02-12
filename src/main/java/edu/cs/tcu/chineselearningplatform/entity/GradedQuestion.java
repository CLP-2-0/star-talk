package edu.cs.tcu.chineselearningplatform.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Document("GradedQuestion")
public class GradedQuestion implements Serializable {
    @Id
    private String id;
    private Question question;
    private Integer point;
    private Map<String, String> answersMap = new HashMap<String, String>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Map<String, String> getAnswersMap() {
        return answersMap;
    }

    public void setAnswersMap(Map<String, String> answersMap) {
        this.answersMap = answersMap;
    }

    public void addAnswer(String username, String answerId) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        answersMap.put(timestamp.getTime() + "-"+ username, answerId);
    }
}
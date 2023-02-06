package edu.cs.tcu.chineselearningplatform.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document("GradedQuestion")
public class GradedQuestion implements Serializable {
    private Question question;
    private Integer point;

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
}
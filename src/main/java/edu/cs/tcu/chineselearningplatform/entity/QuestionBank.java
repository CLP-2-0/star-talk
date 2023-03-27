package edu.cs.tcu.chineselearningplatform.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document("QuestionBank")
public class QuestionBank implements Serializable {
    @Id
    private String id;
    @DBRef
    private List<Question> questionList = new ArrayList<>();
    private String lid;

    public QuestionBank() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public void addQuestion(Question question) {
        questionList.add(question);
    }

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }
}

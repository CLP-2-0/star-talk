package edu.cs.tcu.chineselearningplatform.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;


@Document("Question")
public class Question implements Serializable {
    @Id
    private String id;
    private String question;
    private String answer;


    @DBRef
    private Lesson belongedTo;

    public Question() {

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @JsonIgnore
    public Lesson getLesson() {
        return belongedTo;
    }

    public void setLesson(Lesson belongedTo) {
        this.belongedTo = belongedTo;
    }
}

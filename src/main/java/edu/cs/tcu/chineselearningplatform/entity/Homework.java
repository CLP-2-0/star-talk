package edu.cs.tcu.chineselearningplatform.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document("Homework")
public class Homework implements Serializable {
    @Id
    private String id;
    private Section section;
    private Lesson lesson;
    @DBRef
    private List<GradedQuestion> questionList = new ArrayList<>();
    private String time;

    public Homework(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public List<GradedQuestion> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<GradedQuestion> questionList) {
        this.questionList = questionList;
    }

    public String getTime() {
        return time;
    }


    public void setTime(String time) {
        this.time = time;
    }
}

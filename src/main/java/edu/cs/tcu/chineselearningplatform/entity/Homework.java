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
    private String type;
    private String attachment;
    @DBRef
    private List<GradedQuestion> questionList = new ArrayList<>();
    private List<Integer> points = new ArrayList<>();

    public Homework(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public List<Integer> getPoints() {
        return points;
    }

    public void setGrade(List<Integer> points) {
        this.points = points;
    }

    public List<GradedQuestion> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<GradedQuestion> questionList) {
        this.questionList = questionList;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

}

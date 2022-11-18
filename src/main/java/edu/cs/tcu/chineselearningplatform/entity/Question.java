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
    private String lessonId;
    private String content;

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

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @JsonIgnore
    public Lesson getLesson() {
        return belongedTo;
    }

    public void setLesson(Lesson belongedTo) {
        this.belongedTo = belongedTo;
    }
}

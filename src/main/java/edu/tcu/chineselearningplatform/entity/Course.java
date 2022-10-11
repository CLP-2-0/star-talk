package edu.tcu.chineselearningplatform.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document("courses")
public class Course implements Serializable {
    @Id
    private String id;
    private String title;

    @JsonManagedReference
    private User instructor;

    @DBRef
    @JsonManagedReference
    private List<User> students;

    @DBRef
    private Book book;

    @DBRef
    @JsonBackReference
    private List<Homework> homeworks;

    public Course() {

    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getInstructor() {
        return instructor;
    }

    public void setInstructor(User instructor) {
        this.instructor = instructor;
    }

}

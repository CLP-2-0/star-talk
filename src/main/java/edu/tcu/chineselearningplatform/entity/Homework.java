package edu.tcu.chineselearningplatform.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document("homeworks")
public class Homework implements Serializable {
    @Id
    private String id;

    @JsonManagedReference
    private Course belongedTo;

    public Homework() {

    }
}

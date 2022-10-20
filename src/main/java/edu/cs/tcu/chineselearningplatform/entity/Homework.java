package edu.cs.tcu.chineselearningplatform.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

public class Homework implements Serializable {
    @Id
    private String id;

    private Course belongedTo;

    public Homework() {

    }
}

package edu.cs.tcu.chineselearningplatform.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document("User")
public class User implements Serializable {
    @Id
    private String id;
    private String name;
    private String username;
    private String password;
    private String role;
    @DBRef
    private List<Section> sections = new ArrayList<>();

    public User(String username) {
        this.username = username;
    }

    public void addSection(Section section){
        this.sections.add(section);
        section.setInstructor(this);
    }

    public void removeSection(Section section){
        this.sections.remove(section);
        section.setInstructor(null);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @JsonIgnore
    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}

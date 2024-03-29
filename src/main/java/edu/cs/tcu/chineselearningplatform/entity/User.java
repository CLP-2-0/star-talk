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
    private String nickname;
    private String username;
    private String lastname;
    private String firstname;
    private String email;
    private String email_verified;
    private String picture;
    private String role;
    private String requestedRole;
    @DBRef
    private List<Section> sections = new ArrayList<>();

    @DBRef
    private List<Section> courses = new ArrayList<>();



//    public User(String username) {
//        this.username = username;
//    }

    public void addSection(Section section){
        this.sections.add(section);
        section.setInstructor(this);
    }

    public void removeSection(Section section){
        this.sections.remove(section);
        section.setInstructor(null);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRequestedRole() {
        return requestedRole;
    }

    public void setRequestedRole(String requestedRole) {
        this.requestedRole = requestedRole;
    }

    @JsonIgnore
    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @JsonIgnore
    public List<Section> getCourses() {
        return courses;
    }

    public void setCourses(Section courses) {
        this.courses.add(courses);
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail_verified() {
        return email_verified;
    }

    public void setEmail_verified(String email_verified) {
        this.email_verified = email_verified;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
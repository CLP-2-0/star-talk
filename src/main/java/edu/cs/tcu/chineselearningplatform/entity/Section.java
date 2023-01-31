package edu.cs.tcu.chineselearningplatform.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document("Section")
public class Section implements Serializable {
    @Id
    private String id;
    private String section;

    @DBRef
    private User instructor;

    @DBRef
    private List<User> students;
    private Map<String, String> homeworkMap = new HashMap<>();

    public Section() {

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public User getInstructor() {
        return instructor;
    }

    public void setInstructor(User instructor) {
        this.instructor = instructor;
    }

    public Map<String, String> getHomeworkMap() {
        return homeworkMap;
    }

    public void setHomeworkMap(Map<String, String> homeworkMap) {
        this.homeworkMap = homeworkMap;
    }

    public String addHomework(String lesson, String hw) {
        if(homeworkMap.containsKey(lesson)){
            String oldHw = homeworkMap.get(lesson);
            homeworkMap.put(lesson, hw);
            return oldHw;
        }
        homeworkMap.put(lesson, hw);
        System.out.println("after put");

        return null;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> students) {
        this.students = students;
    }

}

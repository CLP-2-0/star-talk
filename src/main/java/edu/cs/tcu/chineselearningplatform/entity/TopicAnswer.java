package edu.cs.tcu.chineselearningplatform.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Document("TopicAnswer")
public class TopicAnswer implements Serializable {
    @Id
    private String id;
    private String content;

    @DBRef
    private User answerCreator;

    @DBRef
    private ForumTopic topic;

    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @JsonIgnore
    public ForumTopic getTopic() {
        return topic;
    }

    public void setTopic(ForumTopic topic) {
        this.topic = topic;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public User getAnswerCreator() {
        return answerCreator;
    }

    public void setAnswerCreator(User answerCreator) {
        this.answerCreator = answerCreator;
    }


//    public void addAnswerCreator(User answerCreator) {
//        this.answerCreator.add(answerCreator);
//        answerCreator.getTopicAnswer().add(this);
//    }
//
//    public void removeAnswerCreator(User answerCreator) {
//        this.answerCreator = null;
//        answerCreator.setTopicAnswer(null);
//    }
}

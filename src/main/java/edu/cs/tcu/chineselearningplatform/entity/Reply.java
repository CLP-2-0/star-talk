package edu.cs.tcu.chineselearningplatform.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Document("Reply")
public class Reply implements Serializable {
    @Id
    private String id;
    private String content;

    @DBRef
    private User replyCreator;

    @DBRef
    private TopicAnswer topicAnswer;

    private LocalDateTime createdDate;
    private LocalDateTime lastUpdateDate;


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

    public User getReplyCreator() {
        return replyCreator;
    }

    public void setReplyCreator(User replyCreator) {
        this.replyCreator = replyCreator;
    }
    @JsonIgnore
    public TopicAnswer getTopicAnswer() {
        return topicAnswer;
    }

    public void setTopicAnswer(TopicAnswer topicAnswer) {
        this.topicAnswer = topicAnswer;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}

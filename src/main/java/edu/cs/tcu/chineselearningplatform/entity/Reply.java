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

    private String repCreatorUsername;
    private String repCreator;
    private String pictureProfile;

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

    public String getRepCreatorUsername() {
        return repCreatorUsername;
    }

    public void setRepCreatorUsername(String repCreatorUsername) {
        this.repCreatorUsername = repCreatorUsername;
    }

    public String getRepCreator() {
        return repCreator;
    }

    public void setRepCreator(String repCreator) {
        this.repCreator = repCreator;
    }

    public String getPictureProfile() {
        return pictureProfile;
    }

    public void setPictureProfile(String pictureProfile) {
        this.pictureProfile = pictureProfile;
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

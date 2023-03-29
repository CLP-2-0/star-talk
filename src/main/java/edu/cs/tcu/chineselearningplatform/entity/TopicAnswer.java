package edu.cs.tcu.chineselearningplatform.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document("TopicAnswer")
public class TopicAnswer implements Serializable {
    @Id
    private String id;
    private String content;

    private String ansCreatorUsername;
    private String ansCreator;
    private String pictureProfile;

    @DBRef
    private ForumTopic topic;

    @DBRef
    private List<Reply> replies = new ArrayList<>();

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

    public String getAnsCreatorUsername() {
        return ansCreatorUsername;
    }

    public void setAnsCreatorUsername(String ansCreatorUsername) {
        this.ansCreatorUsername = ansCreatorUsername;
    }

    public String getAnsCreator() {
        return ansCreator;
    }

    public void setAnsCreator(String ansCreator) {
        this.ansCreator = ansCreator;
    }

    public String getPictureProfile() {
        return pictureProfile;
    }

    public void setPictureProfile(String pictureProfile) {
        this.pictureProfile = pictureProfile;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public void addReply(Reply reply){
        this.replies.add(reply);
        reply.setTopicAnswer(this);
    }
    public void removeReply(Reply reply){
        this.replies.remove(reply);
        reply.setTopicAnswer(null);
    }
}

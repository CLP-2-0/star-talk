package edu.cs.tcu.chineselearningplatform.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document("ForumTopic")
public class ForumTopic implements Serializable {
    @Id
    private String id;
    private String title;
    private String content;
    private Integer replyCount;
    private LocalDateTime createdDate;
    private LocalDateTime lastPostDate;
    @DBRef
    private List<TopicAnswer> topicAnswer = new ArrayList<>();



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastPostDate() {
        return lastPostDate;
    }

    public void setLastPostDate(LocalDateTime lastPostDate) {
        this.lastPostDate = lastPostDate;
    }


    public List<TopicAnswer> getTopicAnswer() {
        return topicAnswer;
    }

    public void setTopicAnswer(List<TopicAnswer> topicAnswer) {
        this.topicAnswer = topicAnswer;
    }

    public void addAnswer(TopicAnswer answer){
        this.topicAnswer.add(answer);
        answer.setTopic(this);
    }

    public void removeAnswer(TopicAnswer answer){
        this.topicAnswer.remove(answer);
        answer.setTopic(null);
    }
}

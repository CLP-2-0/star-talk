package edu.cs.tcu.chineselearningplatform.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document("Lesson")
public class Lesson implements Serializable {
    @Id
    private String id;
    private String title;
    private String content;
    @DBRef
    private List<Vocab> vocabs = new ArrayList<>();

    public Lesson() {

    }

    /**
     * Method to add a new vocab to this lesson.
     * @param vocab to be added.
     */
    public void addVocab(Vocab vocab){
        this.vocabs.add(vocab);
        vocab.setLesson(this);
    }

    public void removeVocab(Vocab vocab){
        this.vocabs.remove(vocab);
        vocab.setLesson(null);
    }

    public void updateVocab(Vocab oldVocab, Vocab updatedVocab) {
        int idx = -1;
        for(int i = 0; i < vocabs.size(); i++){
            Vocab vocab = vocabs.get(i);
            if(vocab.getMeaning().equals(oldVocab.getMeaning())){
                idx = i;
            }
        }

        this.vocabs.set(idx, updatedVocab);
        updatedVocab.setLesson(this);
    }


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

    public List<Vocab> getVocabs() {
        return vocabs;
    }

    public void setVocabs(List<Vocab> vocabs) {
        this.vocabs = vocabs;
    }
}

package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.VocabRepository;
import edu.cs.tcu.chineselearningplatform.entity.Lesson;
import edu.cs.tcu.chineselearningplatform.entity.Vocab;
import edu.cs.tcu.chineselearningplatform.wrapper.VocabWrapper;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VocabService {
    private VocabRepository vocabRepository;
    private LessonService lessonService;
    private VocabWrapper vocabWrapper;

    public VocabService(VocabRepository vocabRepository, LessonService lessonService){
        this.vocabRepository = vocabRepository;
        this.lessonService = lessonService;
    }




    /**
     * Method to find one vocab.
     * @param id of the vocab to be sought.
     * @return Vocab object
     */
    public Vocab findByObjectId(String id) {
        return vocabRepository.findByObjectId(new ObjectId(id));
    }

    public List<Vocab> findAllByLesson(String lessonId){return vocabRepository.findAllByLesson(lessonId);}

    /**
     * Method to save one vocab.
     * @param vocab to be saved.
     */
    public void save(Vocab newVocab, String lessonId) {
        Lesson lesson = lessonService.findById(lessonId);
        lesson.addVocab(newVocab);
        vocabRepository.save(newVocab);
        lessonService.save(lesson);
    }

    public void saveVocabs(List<Vocab> vocabs, String lessonId){
        for(Vocab v: vocabs){
            save(v, lessonId);
        }
    }
    /**
     * Method to delete one vocab.
     * @param vocab to be deleted.
     */
    public void delete(String vocabId, String lessonId) {
        Lesson lesson = lessonService.findById(lessonId);
        Vocab vocab = vocabRepository.findByObjectId(new ObjectId(vocabId));
        lesson.removeVocab(vocab);
        vocabRepository.delete(vocab);
        lessonService.save(lesson);
    }

    public void update(String vocabId, Vocab updatedVocab, String lessonId) {
        Lesson lesson = lessonService.findById(lessonId);
        Vocab vocab = vocabRepository.findByObjectId(new ObjectId(vocabId));
        System.out.println("first " + lessonId);

        updatedVocab.setId(vocabId);

        lesson.updateVocab(vocab, updatedVocab);
        System.out.println("second " + vocabId);

        vocabRepository.save(updatedVocab);
        lessonService.save(lesson);

    }
}

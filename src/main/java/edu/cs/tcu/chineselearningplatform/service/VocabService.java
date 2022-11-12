package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.VocabRepository;
import edu.cs.tcu.chineselearningplatform.entity.Lesson;
import edu.cs.tcu.chineselearningplatform.entity.Vocab;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class VocabService {
    private VocabRepository vocabRepository;
    private LessonService lessonService;

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

package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.VocabRepository;
import edu.cs.tcu.chineselearningplatform.entity.Lesson;
import edu.cs.tcu.chineselearningplatform.entity.Vocab;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class VocabServiceTest {

    @Mock
    private VocabRepository vocabRepository;

    @Mock
    private LessonService lessonService;

    private VocabService vocabService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        vocabService = new VocabService(vocabRepository, lessonService);
    }

    @Test
    public void testFindByObjectId() {
        ObjectId vocabId = new ObjectId();
        Vocab expectedVocab = new Vocab();
        expectedVocab.setId(vocabId.toString());

        when(vocabRepository.findByObjectId(vocabId)).thenReturn(expectedVocab);

        Vocab actualVocab = vocabService.findByObjectId(vocabId.toString());

        assertEquals(expectedVocab, actualVocab);
        verify(vocabRepository, times(1)).findByObjectId(vocabId);
    }

    @Test
    public void testFindAllByLesson() {
        String lessonId = "lesson123";
        List<Vocab> expectedVocabs = new ArrayList<>();
        expectedVocabs.add(new Vocab());
        expectedVocabs.add(new Vocab());

        when(vocabRepository.findAllByLesson(lessonId)).thenReturn(expectedVocabs);

        List<Vocab> actualVocabs = vocabService.findAllByLesson(lessonId);

        assertEquals(expectedVocabs, actualVocabs);
        verify(vocabRepository, times(1)).findAllByLesson(lessonId);
    }

    @Test
    public void testSaveVocabs() {
        String lessonId = "lesson123";
        List<Vocab> vocabsToSave = new ArrayList<>();
        Vocab vocab1 = new Vocab();
        vocab1.setId("vocab1");
        Vocab vocab2 = new Vocab();
        vocab2.setId("vocab2");
        vocabsToSave.add(vocab1);
        vocabsToSave.add(vocab2);

        Lesson lesson = new Lesson();
        lesson.setId(lessonId);

        when(lessonService.findById(lessonId)).thenReturn(lesson);

        vocabService.saveVocabs(vocabsToSave, lessonId);

        verify(vocabRepository, times(2)).save(any(Vocab.class));
        verify(lessonService, times(1)).save(lesson);
    }

//    @Test
//    public void testDelete() {
//        String vocabId = "vocab123";
//        String lessonId = "lesson123";
//        Vocab vocab = new Vocab();
//        Lesson lesson = new Lesson();
//        lesson.setId(lessonId);
//
//        when(lessonService.findById(lessonId)).thenReturn(lesson);
//        when(vocabRepository.findByObjectId(new ObjectId(vocabId))).thenReturn(vocab);
//
//        vocabService.delete(vocabId, lessonId);
//
//        verify(vocabRepository, times(1)).delete(vocab);
//        verify(lessonService, times(1)).save(lesson);
//    }

//    @Test
//    public void testUpdate() {
//        Lesson lesson = new Lesson();
//        lesson.setTitle("Test Lesson");
//        lessonService.save(lesson);
//
//        Vocab vocab = new Vocab();
//        vocab.setWord("Test Word");
//        vocab.setLesson(lesson);
//        vocabService.save(vocab, lesson.getId(), new ArrayList<Vocab>());
//
//        Vocab updatedVocab = new Vocab();
//        updatedVocab.setWord("Updated Word");
//
//        String vocabId = vocab.getId();
//        vocabService.update(vocabId, updatedVocab, lesson.getId());
//
//        Vocab retrievedVocab = vocabService.findByObjectId(vocabId);
//        assertEquals(updatedVocab.getWord(), retrievedVocab.getWord());
//    }


}
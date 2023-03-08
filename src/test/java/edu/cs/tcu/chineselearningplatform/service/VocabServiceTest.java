package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.VocabRepository;
import edu.cs.tcu.chineselearningplatform.entity.Lesson;
import edu.cs.tcu.chineselearningplatform.entity.Vocab;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class VocabServiceTest {

    @Mock
    private VocabRepository vocabRepository;

    @Mock
    private LessonService lessonService;

    private VocabService vocabService;

    private Vocab vocab;
    private Vocab updatedVocab;
    private String vocabId;
    private String lessonId;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        vocabService = new VocabService(vocabRepository, lessonService);

        lessonId = "1";
        vocabId = "1";
        vocab = new Vocab();
        vocab.setId(vocabId);
        vocab.setWord("hello");
        updatedVocab = new Vocab();
        updatedVocab.setId(vocabId);
        updatedVocab.setWord("hi");

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
    @Test
    public void testUpdateVocab() {
        // Given
        String vocabId = "1";
        String lessonId = "123";
        Vocab oldVocab = new Vocab();
        oldVocab.setId(vocabId);
        oldVocab.setWord("oldWord");
        oldVocab.setMeaning("oldMeaning");
        Vocab updatedVocab = new Vocab();
        updatedVocab.setId(vocabId);
        updatedVocab.setWord("updatedWord");
        updatedVocab.setMeaning("updatedMeaning");
        Lesson lesson = new Lesson();
        lesson.setId(lessonId);
        lesson.addVocab(oldVocab);

        given(this.lessonService.findById(lessonId)).willReturn(lesson);
        given(this.vocabRepository.findByObjectId(new ObjectId(vocabId))).willReturn(oldVocab);
        given(this.vocabRepository.save(updatedVocab)).willReturn(updatedVocab);

        // When
        Vocab actualVocab = vocabService.update(vocabId, updatedVocab, lessonId);

        // Then
        assertThat(actualVocab).isEqualTo(updatedVocab);
        assertThat(actualVocab.getWord()).isEqualTo(updatedVocab.getWord());
        assertThat(actualVocab.getMeaning()).isEqualTo(updatedVocab.getMeaning());
        verify(this.lessonService, times(1)).findById(lessonId);
        verify(this.vocabRepository, times(1)).findByObjectId(new ObjectId(vocabId));
        verify(this.vocabRepository, times(1)).save(updatedVocab);
        verify(lesson, times(1)).updateVocab(oldVocab, updatedVocab);
        verify(this.lessonService, times(1)).save(lesson);
    }



    @Test
    public void testDeleteVocab() {
        // Given
        Lesson lesson = new Lesson();
        Vocab vocab = new Vocab();
        vocab.setWord("testword");
        lesson.addVocab(vocab);

        given(this.lessonService.findById("lesson1")).willReturn(lesson);
        given(this.vocabRepository.findByObjectId(new ObjectId("6174df345f14ad9c7a330f1d"))).willReturn(vocab);

        // When
        vocabService.delete("6174df345f14ad9c7a330f1d", "lesson1");

        // Then
        assertThat(lesson.getVocabs()).doesNotContain(vocab);
        verify(this.lessonService, times(1)).findById("lesson1");
        verify(this.vocabRepository, times(1)).findByObjectId(new ObjectId("6174df345f14ad9c7a330f1d"));
        verify(this.vocabRepository, times(1)).delete(vocab);
        verify(this.lessonService, times(1)).save(lesson);
    }



}
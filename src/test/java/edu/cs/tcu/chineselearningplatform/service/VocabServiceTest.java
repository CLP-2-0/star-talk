//package edu.cs.tcu.chineselearningplatform.service;
//
//import edu.cs.tcu.chineselearningplatform.dao.VocabRepository;
//import edu.cs.tcu.chineselearningplatform.entity.Lesson;
//import edu.cs.tcu.chineselearningplatform.entity.Vocab;
//import org.bson.types.ObjectId;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.doAnswer;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class VocabServiceTest {
//
//    @Mock
//    VocabRepository vocabRepository;
//    @Mock
//    LessonService lessonService;
//    @InjectMocks
//    VocabService vocabService;
//
//    @Test
//    void findByObjectId() {
//        Vocab vocab1 = new Vocab();
//        vocab1.setWord("hello");
//        vocab1.setMeaning("greeting");
//
//        when(vocabRepository.findByObjectId(any(ObjectId.class)))
//                .thenReturn(vocab1);
//
//        Vocab res = vocabService.findByObjectId("6342139d1d62b17c341a49b1");
//
//        assertEquals(vocab1.getWord(), res.getWord());
//    }
//
//    @Test
//    void save() {
//        Vocab vocab1 = new Vocab();
//        vocab1.setWord("hello");
//        vocab1.setMeaning("greeting");
//
//        Lesson lesson = new Lesson();
//        lesson.setId("100");
//
//        when(lessonService.findById(any(String.class))).thenReturn(lesson);
//
//        doAnswer(invocation -> {
//            Object arg0 = invocation.getArgument(0);
//
//            assertEquals(vocab1, arg0);
//            return null;
//        }).when(vocabRepository).save(any(Vocab.class));
//
//        doAnswer(invocation -> {
//            Object arg0 = invocation.getArgument(0);
//
//            assertEquals(lesson, arg0);
//            return null;
//        }).when(lessonService).save(any(Lesson.class));
////        vocabService.save(vocab1, "100");
//    }
//
//    @Test
//    void delete() {
//        Vocab vocab1 = new Vocab();
//        vocab1.setWord("hello");
//        vocab1.setMeaning("greeting");
//
//        Lesson lesson = new Lesson();
//        lesson.setId("100");
//
//        when(lessonService.findById(any(String.class))).thenReturn(lesson);
//        when(vocabRepository.findByObjectId(any(ObjectId.class))).thenReturn(vocab1);
//        doAnswer(invocation -> {
//            Object arg0 = invocation.getArgument(0);
//
//            assertEquals(vocab1, arg0);
//            return null;
//        }).when(vocabRepository).delete(any(Vocab.class));
//
//        doAnswer(invocation -> {
//            Object arg0 = invocation.getArgument(0);
//
//            assertEquals(lesson, arg0);
//            return null;
//        }).when(lessonService).save(any(Lesson.class));
//        vocabService.delete("6342139d1d62b17c341a49b1", "100");
//    }
//}
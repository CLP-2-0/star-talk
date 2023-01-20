//package edu.cs.tcu.chineselearningplatform.controller;
//
//import edu.cs.tcu.chineselearningplatform.entity.Vocab;
//import edu.cs.tcu.chineselearningplatform.entity.util.Result;
//import edu.cs.tcu.chineselearningplatform.service.VocabService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.isA;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class VocabControllerTest {
//
//    @Mock
//    VocabService vocabService;
//    @InjectMocks
//    VocabController vocabController;
//
//    @Test
//    void findById() {
//        Vocab vocab1 = new Vocab();
//        vocab1.setWord("hello");
//        vocab1.setMeaning("greeting");
//
//        when(vocabService.findByObjectId("testVocab1"))
//                .thenReturn(vocab1);
//
//        Result r = vocabController.findById("testVocab1");
//        assertEquals(vocab1, r.getData());
//    }
//
//    @Test
//    void save() {
//        Vocab vocab1 = new Vocab();
//        vocab1.setWord("hello");
//        vocab1.setMeaning("greeting");
//
//        doNothing().when(vocabService).save(isA(Vocab.class), isA(String.class));
//        vocabService.save(vocab1, "100");
//
//        verify(vocabService, times(1)).save(vocab1, "100");
//
//    }
//
//    @Test
//    void deleteById() {
//        Vocab vocab1 = new Vocab();
//        vocab1.setWord("hello");
//        vocab1.setMeaning("greeting");
//
//        doNothing().when(vocabService).delete(isA(String.class), isA(String.class));
//        vocabService.delete("abc", "100");
//
//        verify(vocabService, times(1)).delete("abc", "100");
//    }
//}
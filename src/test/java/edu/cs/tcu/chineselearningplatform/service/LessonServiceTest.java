package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.LessonRepository;
import edu.cs.tcu.chineselearningplatform.entity.Lesson;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class LessonServiceTest {
    @Mock
    LessonRepository lessonRepository;
    @InjectMocks
    LessonService lessonService;


    /*
    @Test
    void update() {
        Lesson lesson1 = new Lesson();
        lesson1.setTitle("Chinese lesson5");
        lesson1.setContent("this is lesson 5");

    }
*/

}
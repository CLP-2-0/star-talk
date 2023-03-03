package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.GradedQuestionRepository;
import edu.cs.tcu.chineselearningplatform.dao.HomeworkRepository;
import edu.cs.tcu.chineselearningplatform.dao.SectionRepository;
import edu.cs.tcu.chineselearningplatform.entity.*;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class HomeworkServiceTest {

    @Mock
    HomeworkRepository homeworkRepository;

    @Mock
    SectionService sectionService;

    @Mock
    LessonService lessonService;

    @Mock
    SectionRepository sectionRepository;

    @Mock
    GradedQuestionRepository gradedQuestionRepository;

    @InjectMocks
    HomeworkService homeworkService;

    private Section section;
    private Lesson lesson;
    private GradedQuestion gradedQuestion;
    private List<GradedQuestion> gradedQuestionList;
    private Homework homework;

    @BeforeEach
    public void setUp() {
        section = new Section();
        section.setId("1");
        section.setSection("Section 1");

        lesson = new Lesson();
        lesson.setId("1");
        lesson.setTitle("Lesson 1");

        gradedQuestion = new GradedQuestion();
        gradedQuestion.setId("1");


        gradedQuestionList = new ArrayList<>();
        gradedQuestionList.add(gradedQuestion);

        homework = new Homework();
        homework.setId("1");
        homework.setSection(section);
        homework.setLesson(lesson);
        homework.setQuestionList(gradedQuestionList);
    }

    @Test
    public void testFindById() {
        // Mock the behavior of the homeworkRepository
        when(homeworkRepository.findById("1")).thenReturn(Optional.of(homework));

        // Call the findById method of the homeworkService
        Homework result = homeworkService.findById("1");

        // Verify the results
        assertEquals(homework, result);
    }

    @Test
    public void testSave() {
        // Mock the behavior of the sectionService and lessonService
        when(sectionService.findById("1")).thenReturn(Optional.of(section));
        when(lessonService.findById("1")).thenReturn(lesson);

        // Mock the behavior of the sectionRepository and gradedQuestionRepository
        when(sectionRepository.save(any(Section.class))).thenReturn(section);
        when(gradedQuestionRepository.save(any(GradedQuestion.class))).thenReturn(gradedQuestion);

        // Call the save method of the homeworkService
        homeworkService.save(gradedQuestionList, "1", "1");

        // Verify that the homeworkRepository.save method was called once
        verify(homeworkRepository, times(1)).save(any(Homework.class));
    }

//    @Test
//    public void testFindHomework() {
//        // Mock the behavior of the sectionService
//        when(sectionService.findById("1")).thenReturn(Optional.of(section));
//
//        // Mock the behavior of the homeworkRepository
//        when(homeworkRepository.findByObjectId(any(ObjectId.class))).thenReturn(homework);
//
//        // Call the findHomework method of the homeworkService
//        Homework result = homeworkService.findHomework("1", "1");
//
//        // Verify the results
//        assertEquals(homework, result);
//    }
}


package edu.cs.tcu.chineselearningplatform.controller;

import edu.cs.tcu.chineselearningplatform.entity.Lesson;
import edu.cs.tcu.chineselearningplatform.entity.util.Result;
import edu.cs.tcu.chineselearningplatform.service.LessonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class LessonControllerTest {

    @Mock
    LessonService lessonService;
    @InjectMocks
    LessonController lessonController;

    List<Lesson> list;

    @Test
    void save() {
        Lesson lesson1 = new Lesson();
        lesson1.setTitle("Chinese lesson5");
        lesson1.setContent("this is lesson 5");

         lessonService.save(lesson1);

        verify(lessonService, times(1)).save(lesson1);

    }

    @Test
    void findById() {
        Lesson lesson1 = new Lesson();
        lesson1.setTitle("Chinese lesson5");
        lesson1.setContent("this is lesson 5");

        when(lessonService.findById("15"))
                .thenReturn(lesson1);

        Result r = lessonController.findById("15");
        assertEquals(lesson1, r.getData());
    }

    @Test
    void findAll() {
        Lesson lesson1 = new Lesson();
        lesson1.setTitle("Chinese lesson5");
        lesson1.setContent("this is lesson 5");

        Lesson lesson2 = new Lesson();
        lesson2.setTitle("Chinese 8");
        lesson2.setContent("<p>\t<u style=\"color: red;\">无论</u><sup style=\"color: black;\"><u>1</u></sup><span style=\"color: black;\">是否学习</span><u style=\"color: black;\">过</u><sup style=\"color: black;\"><u>2</u></sup><span style=\"color: black;\">中文，大家对“你好”这</span><span style=\"color: red;\">句</span><a href=\"about:blank\" rel=\"noopener noreferrer\" target=\"_blank\">[ZJ1]</a>&nbsp;<span style=\"color: black;\"> </span><span style=\"color: red;\">问候语</span><a href=\"about:blank\" rel=\"noopener noreferrer\" target=\"_blank\">[ZJ2]</a>&nbsp;<u style=\"color: black;\">都</u><sup style=\"color: black;\"><u>1</u></sup><span style=\"color: black;\">很</span><span style=\"color: red;\">熟悉</span><span style=\"color: black;\">。“你好”</span><u style=\"color: red;\">类似</u><u style=\"color: black;\">于</u><sup style=\"color: black;\"><u>3</u></sup><span style=\"color: black;\">英文中的“hello”，但是</span><u style=\"color: black;\">没有</u><sup style=\"color: black;\"><u>4</u></sup><span style=\"color: black;\">“hello”在英文中</span><u style=\"color: black;\">那么</u><sup style=\"color: black;\"><u>4</u></sup><span style=\"color: red;\">常见</span><span style=\"color: black;\">。</span></p><p><br></p>");

        list = new ArrayList<>();
        list.add(lesson1);
        list.add(lesson2);

        when(lessonService.findAll()).thenReturn(list);

        assertEquals(2, lessonService.findAll().size());
    }

//    @Test
//    void update() {
//        Lesson lesson1 = new Lesson();
//        Lesson lesson2 = new Lesson();
//        lesson1.setTitle("Chinese lesson5");
//        lesson1.setContent("this is lesson 5");
//        lesson2.setTitle("Updated lesson");
//        lesson2.setContent("updated lesson content");
//
//        when(lessonService.update("15", lesson2)
//                .thenReturn(lesson1);
//
//        Result r = lessonController.findById("15");
//        assertEquals(lesson1, r.getData());
//    }

    @Test
    void delete() {
        Lesson lesson1 = new Lesson();
        lesson1.setTitle("Chinese lesson5");
        lesson1.setContent("this is lesson 5");

        doNothing().when(lessonService).delete(isA(String.class));
        lessonService.delete("15");

        verify(lessonService, times(1)).delete("15");
    }
}
package edu.cs.tcu.chineselearningplatform.controller;

import edu.cs.tcu.chineselearningplatform.entity.Lesson;
import edu.cs.tcu.chineselearningplatform.entity.util.Result;
import edu.cs.tcu.chineselearningplatform.entity.util.StatusCode;
import edu.cs.tcu.chineselearningplatform.service.LessonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/lessons")
public class LessonController {
    private LessonService lessonService;

    public LessonController(LessonService lessonService){
        this.lessonService = lessonService;
    }
    //
    /**
     * Method to save one lesson.
     * @param lesson to be saved.
     * @return Result object that contains flag, status code, message.
     */
    @PostMapping("/save")
    @ResponseBody
    public Result save(@RequestBody Lesson newLesson) {
        lessonService.save(newLesson);
        return new Result(true, StatusCode.SUCCESS, "Save lesson success");
    }
    /**
     * Method to find one lesson.
     * @param id of the lesson to be sought.
     * @return Result object that contains flag, status code, message, and found lesson.
     */
    @GetMapping("/{lessonId}")
    @ResponseBody
    public Result findById(@PathVariable String lessonId) {
        return new Result(true, StatusCode.SUCCESS, "Find lesson by id success", lessonService.findById(lessonId));
    }

}

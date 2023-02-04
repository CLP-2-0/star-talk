package edu.cs.tcu.chineselearningplatform.controller;

import edu.cs.tcu.chineselearningplatform.entity.Lesson;
import edu.cs.tcu.chineselearningplatform.entity.util.Result;
import edu.cs.tcu.chineselearningplatform.entity.util.StatusCode;
import edu.cs.tcu.chineselearningplatform.service.LessonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping
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

    /**
     * Method to find all lesson.
     * @param
     * @return Result object that contains flag, status code, message, and found lesson.
     */
    @GetMapping
    @ResponseBody
    public Result findAll(){
        List<Lesson> all = lessonService.findAll();
        return new Result(true,StatusCode.SUCCESS,"Find all lessons", all);
    }
    @PostMapping("/{lessonId}/grammars")
    @ResponseBody
    public Result setAllGrammarMeanings(@PathVariable("lessonId") String lessonId, @RequestBody List<String> grammarMeanings){
        lessonService.saveGrammarMeanings(lessonId, grammarMeanings);
        return new Result(true,StatusCode.SUCCESS,"Find all lessons");
    }

    @GetMapping("/{lessonId}/grammar-meanings")
    @ResponseBody
    public Result getAllGrammarMeanings(@PathVariable("lessonId") String lessonId){
        List<String> grammarMeanings = lessonService.getSavedGrammarMeanings(lessonId);
        return new Result(true, StatusCode.SUCCESS, "getallgrammarmeanings success", grammarMeanings);
    }

    /**
     * Method to update one lesson.
     * @param lesson to be updated.
     * @return Result object that contains flag, status code, message.
     */
    @PutMapping("/{lessonId}")
    @ResponseBody
    public Result update(@PathVariable String lessonId, @RequestBody Lesson updatedLesson){
        lessonService.update(lessonId,updatedLesson);
        return new Result(true, StatusCode.SUCCESS, "Update lesson success");
    }
    /**
     * Method to delte one lesson.
     * @param lesson to be deleted.
     * @return Result object that contains flag, status code, message.
     */
    @DeleteMapping("/{lessonId}")
    @ResponseBody
    public Result delete(@PathVariable String lessonId){
        lessonService.delete(lessonId);
        return new Result(true,StatusCode.SUCCESS,"Delete lesson success");
    }
}

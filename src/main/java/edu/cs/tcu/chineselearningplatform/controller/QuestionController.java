package edu.cs.tcu.chineselearningplatform.controller;

import edu.cs.tcu.chineselearningplatform.entity.Question;
import edu.cs.tcu.chineselearningplatform.entity.util.Result;
import edu.cs.tcu.chineselearningplatform.entity.util.StatusCode;
import edu.cs.tcu.chineselearningplatform.service.QuestionService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/questions")
public class QuestionController {
    private QuestionService questionService;

    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }


    /**
     * Method to save one question.
     * @param question to be saved.
     * @return Result object that contains flag, status code, message.
     */
    @PostMapping("/{lessonId}")
    @ResponseBody
    public Result save( @RequestBody Question newQuestion, @PathVariable String lessonId) {
        questionService.save(newQuestion, lessonId);
        return new Result(true, StatusCode.SUCCESS, "Save question success");
    }

    @PostMapping("/e/{lessonId}")
    @ResponseBody
    public Result saveExamQuestion( @RequestBody Question newQuestion, @PathVariable String lessonId) {
        questionService.saveExamQuestion(newQuestion, lessonId);
        return new Result(true, StatusCode.SUCCESS, "Save question success");
    }

    /**
     * Method to find one question.
     * @param id of the question to be sought.
     * @return Result object that contains flag, status code, message, and found lesson.
     */
    @GetMapping("/{questionId}")
    @ResponseBody
    public Result findById(@PathVariable String questionId) {
        return new Result(true, StatusCode.SUCCESS, "Find question by id success", questionService.findById(questionId));
    }

    /**
     * Method to find all questions for a lesson.
     * @param id of the question under a lesson to be sought.
     * @return Result object that contains flag, status code, message, and found lesson.
     */
    @GetMapping("question-lesson/{lessonId}")
    @ResponseBody
    public Result findAllByLesson(@PathVariable String lessonId) {
        return new Result(true, StatusCode.SUCCESS, "List of all questions for that lesson", questionService.findAllByLesson(lessonId));
    }


    /**
     * Method to find all questions.
     * @param
     * @return Result object that contains flag, status code, message, and found lesson.
     */
    @GetMapping
    @ResponseBody
    public Result findAll(){
        List<Question> all = questionService.findAll();
        return new Result(true,StatusCode.SUCCESS,"Find all questions", all);
    }

    /**
     * Method to update one question.
     * @param question to be updated.
     * @return Result object that contains flag, status code, message.
     */
    @PutMapping("/{questionId}")
    @ResponseBody
    public Result update( @PathVariable String questionId, @RequestBody Question updatedQuestion){
        questionService.update(questionId, updatedQuestion);
        return new Result(true, StatusCode.SUCCESS, "Update question success");
    }

    /**
     * Method to delete one question.
     * @param question to be deleted.
     * @return Result object that contains flag, status code, message.
     */
    @DeleteMapping("/{questionId}")
    @ResponseBody
    public Result delete( @PathVariable String questionId){
        questionService.delete(questionId);
        return new Result(true,StatusCode.SUCCESS,"Delete question success");
    }


    @PostMapping("/{lessonId}/{sid}")
    @ResponseBody
    public Result saveQuestionToSec( @RequestBody Question newQuestion, @PathVariable String lessonId, @PathVariable String sid) {
        questionService.saveToSec(newQuestion, lessonId, sid);
        return new Result(true, StatusCode.SUCCESS, "Save question success");
    }

    @GetMapping("/{lessonId}/{sid}")
    @ResponseBody
    public Result findQuestionBankByLesson(@PathVariable String lessonId, @PathVariable String sid) {
        return new Result(true, StatusCode.SUCCESS, "List of all questions for that lesson", questionService.getQuestionBankByLesson(lessonId, sid));
    }

    @PostMapping("/e/{lessonId}/{sid}")
    @ResponseBody
    public Result saveEQuestionToSec( @RequestBody Question newQuestion, @PathVariable String lessonId, @PathVariable String sid) {
        questionService.saveEToSec(newQuestion, lessonId, sid);
        return new Result(true, StatusCode.SUCCESS, "Save question success");
    }

    @GetMapping("/e/{lessonId}/{sid}")
    @ResponseBody
    public Result findEQuestionBankByLesson(@PathVariable String lessonId, @PathVariable String sid) {
        return new Result(true, StatusCode.SUCCESS, "List of all questions for that lesson", questionService.getEQuestionBankByLesson(lessonId, sid));
    }
}


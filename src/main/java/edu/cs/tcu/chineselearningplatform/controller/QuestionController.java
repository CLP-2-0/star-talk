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
    @PostMapping
    @ResponseBody
    public Result save( @RequestBody Question newQuestion) {
        questionService.save(newQuestion);
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
}

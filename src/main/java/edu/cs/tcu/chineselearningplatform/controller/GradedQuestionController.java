package edu.cs.tcu.chineselearningplatform.controller;

import edu.cs.tcu.chineselearningplatform.entity.Answer;
import edu.cs.tcu.chineselearningplatform.entity.GradedQuestion;
import edu.cs.tcu.chineselearningplatform.entity.util.Result;
import edu.cs.tcu.chineselearningplatform.entity.util.StatusCode;
import edu.cs.tcu.chineselearningplatform.service.GradedQuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/graded-question")
public class GradedQuestionController {
    private GradedQuestionService gradedQuestionService;

    public GradedQuestionController(GradedQuestionService gradedQuestionService) {
        this.gradedQuestionService = gradedQuestionService;
    }

    /**
     * Method to save one answer.
     * @param id of question to be saved, answer to be saved, username.
     * @return Result object that contains flag, status code, message.
     */
    @PostMapping("/answer/{username}/{id}")
    @ResponseBody
    public Result save(@RequestBody Answer answer, @PathVariable String username, @PathVariable String id) {
        gradedQuestionService.saveAnswerToAQuestion(answer, username, id);
        return new Result(true, StatusCode.SUCCESS, "Save answer success");
    }


    /**
     * Method to find all answers.
     * @param id of the question to be sought.
     * @return Result object that contains flag, status code, message, and found answers.
     */

    @GetMapping("/answers/{id}")
    @ResponseBody
    public Result findAllAnswers(@PathVariable String id) {
        ;
        return new Result(true, StatusCode.SUCCESS, "Find answers by id success", gradedQuestionService.getAllAnswerForAQuestion(id));
    }
}

package edu.cs.tcu.chineselearningplatform.controller;

import edu.cs.tcu.chineselearningplatform.entity.Answer;
import edu.cs.tcu.chineselearningplatform.entity.util.Result;
import edu.cs.tcu.chineselearningplatform.entity.util.StatusCode;
import edu.cs.tcu.chineselearningplatform.service.GradedQuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Controller
@RequestMapping("/graded-question")
public class GradedQuestionController {
    private GradedQuestionService gradedQuestionService;

    public GradedQuestionController(GradedQuestionService gradedQuestionService) {
        this.gradedQuestionService = gradedQuestionService;
    }

    /**
     * Method to save one text answer.
     * @param id of question to be saved, answer to be saved, username.
     * @return Result object that contains flag, status code, message.
     */
    @PostMapping("/answer/{username}/{id}")
    @ResponseBody
    public Result saveTextAnswer(@RequestBody Answer answer, @PathVariable String username, @PathVariable String id) throws IOException, GeneralSecurityException {
        gradedQuestionService.saveAnswerToAQuestion(answer, username, id);
        return new Result(true, StatusCode.SUCCESS, "Save answer success");
    }

    /**
     * Method to save one audio answer.
     * @param id of question to be saved, answer to be saved, username.
     * @return Result object that contains flag, status code, message.
     */
//    @PostMapping(value = "/audio/{username}/{id}")
//    public Result saveAudio(@RequestBody byte[] audioData, @PathVariable String username, @PathVariable String id) throws IOException {
//
//        gradedQuestionService.saveAudioToAQuestion(audioData, username, id);
//        return new Result(true, StatusCode.SUCCESS, "Save audio success");
//    }


    /**
     * Method to find all answers.
     * @param id of the question to be sought.
     * @return Result object that contains flag, status code, message, and found answers.
     */

    @GetMapping("/answers/{id}")
    @ResponseBody
    public Result findAllAnswers(@PathVariable String id) {
        return new Result(true, StatusCode.SUCCESS, "Find answers by id success", gradedQuestionService.getAllAnswerForAQuestion(id));
    }

    @PostMapping("/comment/{username}/{id}/{comment}")
    @ResponseBody
    public Result saveTextAnswer(@PathVariable String comment, @PathVariable String username, @PathVariable String id) {
        gradedQuestionService.saveCommentToAnAnswer(comment, username, id);
        return new Result(true, StatusCode.SUCCESS, "Save answer success");
    }

    @GetMapping("/comments/{id}")
    @ResponseBody
    public Result findAllComments(@PathVariable String id) {
        return new Result(true, StatusCode.SUCCESS, "Find answers by id success", gradedQuestionService.getAllCommentsForAnAnswer(id));
    }
}

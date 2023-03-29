package edu.cs.tcu.chineselearningplatform.controller;

import edu.cs.tcu.chineselearningplatform.entity.TopicAnswer;
import edu.cs.tcu.chineselearningplatform.entity.util.Result;
import edu.cs.tcu.chineselearningplatform.entity.util.StatusCode;
import edu.cs.tcu.chineselearningplatform.service.TopicAnswerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/topicanswer")
public class TopicAnswerController {
    private TopicAnswerService topicAnswerService;

    public TopicAnswerController(TopicAnswerService topicAnswerService) {
        this.topicAnswerService = topicAnswerService;
    }

    @PostMapping("/{topicId}/answer")
    @ResponseBody
    public Result createAnswer(@PathVariable String topicId, @RequestBody TopicAnswer answer) {
        topicAnswerService.createAnswer(topicId, answer);
        return new Result(true, StatusCode.SUCCESS, "Answer added to topic");
    }
}

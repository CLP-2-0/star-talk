package edu.cs.tcu.chineselearningplatform.controller;

import edu.cs.tcu.chineselearningplatform.entity.ForumTopic;
import edu.cs.tcu.chineselearningplatform.entity.Lesson;
import edu.cs.tcu.chineselearningplatform.entity.TopicAnswer;
import edu.cs.tcu.chineselearningplatform.entity.util.Result;
import edu.cs.tcu.chineselearningplatform.entity.util.StatusCode;
import edu.cs.tcu.chineselearningplatform.service.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/topics")
public class TopicController {
    private TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    @ResponseBody
    public Result findAllTopic(){
        List<ForumTopic> all = topicService.findAll();
        return new Result(true, StatusCode.SUCCESS,"Find all topic!", all);

    }

    @GetMapping("/{topicId}")
    @ResponseBody
    public Result findTopicById(@PathVariable String topicId) {
        return new Result(true, StatusCode.SUCCESS, "Find by id success", topicService.findTopicById(topicId));
    }

    @PostMapping
    @ResponseBody
    public Result createTopic(@RequestBody ForumTopic newTopic) {
        topicService.createTopic(newTopic);
        return new Result(true, StatusCode.SUCCESS, "Save success");
    }

    @PutMapping("/{topicId}")
    @ResponseBody
    public Result updateTopic(@PathVariable String topicId, @RequestBody ForumTopic updatedTopic){
        topicService.updateTopic(topicId,updatedTopic);
        return new Result(true, StatusCode.SUCCESS, "updated");
    }

    @DeleteMapping("/{topicId}")
    @ResponseBody
    public Result delete(@PathVariable String topicId){
        topicService.delete(topicId);
        return new Result(true,StatusCode.SUCCESS,"Delete success");
    }

    @PostMapping("/{topicId}/answers")
    @ResponseBody
    public Result createAnswer(@PathVariable String topicId, @RequestBody TopicAnswer newAnswer) {
        topicService.createAnswer(topicId, newAnswer);
        return new Result(true, StatusCode.SUCCESS, "Answer added to topic");
    }

    @GetMapping("/{topicId}/answers")
    @ResponseBody
    public Result findAllAnswersByTopicId(@PathVariable String topicId) {
        List<TopicAnswer> allAnswers = topicService.findAllAnswersByTopicId(topicId);
        return new Result(true, StatusCode.SUCCESS, "Find all answers by topic id!", allAnswers);
    }
}


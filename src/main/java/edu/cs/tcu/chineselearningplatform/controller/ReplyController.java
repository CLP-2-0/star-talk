package edu.cs.tcu.chineselearningplatform.controller;


import edu.cs.tcu.chineselearningplatform.entity.Reply;
import edu.cs.tcu.chineselearningplatform.entity.util.Result;
import edu.cs.tcu.chineselearningplatform.entity.util.StatusCode;
import edu.cs.tcu.chineselearningplatform.service.ReplyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/replies")
public class ReplyController {

    private ReplyService replyService;

    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @PostMapping("/{answerId}/reply/{username}")
    @ResponseBody
    public Result createReply(@PathVariable String answerId, @RequestBody Reply reply, @PathVariable String username){
        replyService.createReply(answerId,reply,username);
        return new Result(true, StatusCode.SUCCESS, "Reply added to TopicAns");
    }
}

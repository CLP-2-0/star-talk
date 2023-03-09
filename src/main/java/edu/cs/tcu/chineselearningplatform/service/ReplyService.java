package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.ReplyRepository;
import edu.cs.tcu.chineselearningplatform.dao.TopicAnswerRepository;
import edu.cs.tcu.chineselearningplatform.dao.UserRepository;
import edu.cs.tcu.chineselearningplatform.entity.Reply;
import edu.cs.tcu.chineselearningplatform.entity.TopicAnswer;
import edu.cs.tcu.chineselearningplatform.entity.User;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {

    private ReplyRepository replyRepository;
    private TopicAnswerRepository topicAnswerRepository;
    private UserRepository userRepository;

    public ReplyService(ReplyRepository replyRepository, TopicAnswerRepository topicAnswerRepository, UserRepository userRepository) {
        this.replyRepository = replyRepository;
        this.topicAnswerRepository = topicAnswerRepository;
        this.userRepository = userRepository;
    }

    public void createReply(String answerId, Reply reply, String username) {
        TopicAnswer answer = topicAnswerRepository.findById(answerId).get();
        User replyCreator = userRepository.findByUsername(username);
        reply.setReplyCreator(replyCreator);
        answer.addReply(reply);
        topicAnswerRepository.save(answer);
        replyRepository.save(reply);
    }
}

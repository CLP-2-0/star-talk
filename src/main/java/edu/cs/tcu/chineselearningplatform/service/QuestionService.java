package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.QuestionBankRepository;
import edu.cs.tcu.chineselearningplatform.dao.QuestionRepository;
import edu.cs.tcu.chineselearningplatform.entity.Lesson;
import edu.cs.tcu.chineselearningplatform.entity.Question;
import edu.cs.tcu.chineselearningplatform.entity.QuestionBank;
import edu.cs.tcu.chineselearningplatform.entity.Section;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;
    private LessonService lessonService;
    private SectionService sectionService;
    private QuestionBankRepository questionBankRepository;


    public QuestionService(QuestionRepository questionRepository, LessonService lessonService, SectionService sectionService, QuestionBankRepository questionBankRepository){

        this.questionRepository = questionRepository;
        this.lessonService = lessonService;
        this.sectionService = sectionService;
        this.questionBankRepository = questionBankRepository;
    }

    /**
     * Method to find one question.
     * @param id of the question to be sought.
     * @return Result object that contains flag, status code, message, and found homework.
     */
    public Question findById(String id) {
        return questionRepository.findById(id).get();
    }

    public List<Question> findAllByLesson(String lessonId) {
        return questionRepository.findAllByLesson(lessonId);
    }


    /**
     * Method to save one question.
     * @param question to be saved.
     * @return Result object that contains flag, status code, message.
     */
    public void save(Question newQuestion, String lessonId) {
        Lesson lesson = lessonService.findById(lessonId);
        lesson.addQuestion(newQuestion);
        System.out.println(lessonId);
        questionRepository.save(newQuestion);
        lessonService.save(lesson);
    }

    public void saveExamQuestion(Question newQuestion, String lessonId) {
        Lesson lesson = lessonService.findById(lessonId);
        lesson.addEQuestion(newQuestion);
        System.out.println(lessonId);
        questionRepository.save(newQuestion);
        lessonService.save(lesson);
    }

    /**
     * Method to find all homework.
     * @param
     * @return Result object that contains flag, status code, message, and found lesson.
     */
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    /**
     * Method to update one question.
     * @param question to be updated.
     * @return Result object that contains flag, status code, message.
     */
    public void update(String questionId, Question updatedQuestion) {
        updatedQuestion.setId(questionId);
        questionRepository.save(updatedQuestion);

    }

    /**
     * Method to delete one question.
     * @param question to be deleted.
     * @return Result object that contains flag, status code, message.
     */
    public void delete(String questionId) {
        Question question = questionRepository.findById(questionId).get();
        questionRepository.delete(question);
    }

    public QuestionBank findQuestionBank(String id) {
        QuestionBank questionBank = questionBankRepository.findById(id).get();
        return questionBank;
    }

    public void saveToSec(Question newQuestion, String lessonId, String sid) {
        questionRepository.save(newQuestion);
        Section section = sectionService.findById(sid).get();
        Map<String, String> questionBankMap = section.getQuestionBankMap();
        if(questionBankMap.containsKey(lessonId)) {
            String questionBankId = questionBankMap.get(lessonId);
            QuestionBank questionBank = findQuestionBank(questionBankId);
            questionBank.addQuestion(newQuestion);
            questionBankRepository.save(questionBank);
        } else {
            List<Question> questionList = new ArrayList<>();
            questionList.add(newQuestion);
            QuestionBank questionBank = new QuestionBank();
            questionBank.setQuestionList(questionList);
            questionBankRepository.save(questionBank);
            questionBankMap.put(lessonId, questionBank.getId());
        }
        sectionService.saveSection(section);
    }

    public List<Question> getQuestionBankByLesson(String lesson, String sid) {
        Section section = sectionService.findById(sid).get();
        Map<String, String> questionBankMap = section.getQuestionBankMap();
        if(questionBankMap.containsKey(lesson)) {
            String questionBankId = questionBankMap.get(lesson);
            QuestionBank questionBank = findQuestionBank(questionBankId);
            return questionBank.getQuestionList();
        }
        return new ArrayList<Question>();

    }

    public void saveEToSec(Question newQuestion, String lessonId, String sid) {
        questionRepository.save(newQuestion);
        Section section = sectionService.findById(sid).get();
        Map<String, String> equestionBankMap = section.getEquestionBankMap();
        if(equestionBankMap.containsKey(lessonId)) {
            String questionBankId = equestionBankMap.get(lessonId);
            QuestionBank questionBank = findQuestionBank(questionBankId);
            questionBank.addQuestion(newQuestion);
            questionBankRepository.save(questionBank);
        } else {
            List<Question> questionList = new ArrayList<>();
            questionList.add(newQuestion);
            QuestionBank questionBank = new QuestionBank();
            questionBank.setQuestionList(questionList);
            questionBankRepository.save(questionBank);
            equestionBankMap.put(lessonId, questionBank.getId());
        }
        sectionService.saveSection(section);
    }

    public List<Question> getEQuestionBankByLesson(String lesson, String sid) {
        Section section = sectionService.findById(sid).get();
        Map<String, String> equestionBankMap = section.getEquestionBankMap();
        if(equestionBankMap.containsKey(lesson)) {
            String questionBankId = equestionBankMap.get(lesson);
            QuestionBank questionBank = findQuestionBank(questionBankId);
            return questionBank.getQuestionList();
        }
        return new ArrayList<Question>();

    }

}

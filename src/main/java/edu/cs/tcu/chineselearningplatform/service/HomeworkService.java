package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.*;
import edu.cs.tcu.chineselearningplatform.entity.*;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeworkService {
    private HomeworkRepository homeworkRepository;
    private SectionService sectionService;
    private LessonService lessonService;
    private SectionRepository sectionRepository;
    private GradedQuestionRepository gradedQuestionRepository;

    public HomeworkService(HomeworkRepository homeworkRepository, SectionService sectionService, LessonService lessonService, SectionRepository sectionRepository, GradedQuestionRepository gradedQuestionRepository){
        this.homeworkRepository = homeworkRepository;
        this.sectionService = sectionService;
        this.lessonService = lessonService;
        this.sectionRepository = sectionRepository;
        this.gradedQuestionRepository = gradedQuestionRepository;
    }

    /**
     * Method to find one homework.
     * @param id of the homework to be sought.
     * @return Result object that contains flag, status code, message, and found homework.
     */
    public Homework findById(String id) {
        return homeworkRepository.findById(id).get();
    }

    public Homework findHomework(String sid, String lid) {
        Section currSection = sectionService.findById(sid).get();
        String homeworkId = currSection.getHomeworkMap().get(lid);
        Homework hw = homeworkRepository.findByObjectId(new ObjectId(homeworkId));
        return hw;
    }

    /**
     * Method to save one homework.
     * @param homework to be saved.
     * @return Result object that contains flag, status code, message.
     */
    public void save(List<GradedQuestion> questions, String sid, String lid) {
        System.out.println("save homework");
        for(GradedQuestion q: questions) {
            gradedQuestionRepository.save(q);
        }
        Homework hw = new Homework();
        hw.setQuestionList(questions);
        Section currSection = sectionService.findById(sid).get();
        hw.setSection(currSection);
        Lesson currLesson = lessonService.findById(lid);
        hw.setLesson(currLesson);
        homeworkRepository.save(hw);
        String updateOldHw = currSection.addHomework(lid, hw.getId());
        System.out.println(currSection + " line 67 " + updateOldHw);
        System.out.println("new hw " + hw.getId());


        sectionRepository.save(currSection);

        if(updateOldHw != null) {
            Homework oldHw = homeworkRepository.findByObjectId(new ObjectId(updateOldHw));
            for(GradedQuestion q: oldHw.getQuestionList()){
                gradedQuestionRepository.delete(q);
            }
            homeworkRepository.delete(oldHw);
        }


    }

    /**
     * Method to find all homework.
     * @param
     * @return Result object that contains flag, status code, message, and found lesson.
     */
    public List<Homework> findAll() {
        return homeworkRepository.findAll();
    }

    /**
     * Method to update one homework.
     * @param homework to be updated.
     * @return Result object that contains flag, status code, message.
     */
    public void update(String homeworkId, Homework updatedHomework) {
        updatedHomework.setId(homeworkId);
        homeworkRepository.save(updatedHomework);

    }

    /**
     * Method to delete one homework.
     * @param homework to be deleted.
     * @return Result object that contains flag, status code, message.
     */
    public void delete(String homeworkId) {
        Homework homework = homeworkRepository.findById(homeworkId).get();
        homeworkRepository.delete(homework);
    }
}

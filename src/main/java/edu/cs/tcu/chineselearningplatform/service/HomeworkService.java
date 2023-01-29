package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.HomeworkRepository;
import edu.cs.tcu.chineselearningplatform.dao.QuestionRepository;
import edu.cs.tcu.chineselearningplatform.entity.Homework;
import edu.cs.tcu.chineselearningplatform.entity.Question;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HomeworkService {
    private HomeworkRepository homeworkRepository;

    public HomeworkService(HomeworkRepository homeworkRepository){
        this.homeworkRepository = homeworkRepository;
    }

    /**
     * Method to find one homework.
     * @param id of the homework to be sought.
     * @return Result object that contains flag, status code, message, and found homework.
     */
    public Homework findById(String id) {
        return homeworkRepository.findById(id).get();
    }

    public Homework findByObjectId(String id) {
        return homeworkRepository.findByObjectId(new ObjectId(id));
    }


    public List<Homework> findAllBySection(String sectionId) {
        return homeworkRepository.findAllBySection(sectionId);
    }

    public List<Homework> findAllByUserId(String userId) {
        return homeworkRepository.findAllByUserId(userId);
    }

    public List<Homework> findAllByQuestionId(String questionId) {
        return homeworkRepository.findAllByQuestionId(questionId);
    }


    /**
     * Method to save one homework.
     * @param homework to be saved.
     * @return Result object that contains flag, status code, message.
     */
    public void save(Homework newHomework) {
        homeworkRepository.save(newHomework);
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

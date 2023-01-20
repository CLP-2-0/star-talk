package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.UserRepository;
import edu.cs.tcu.chineselearningplatform.entity.User;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     * Method to find one user.
     * @param username of the user to be sought.
     * @return Result object that contains flag, status code, message, and found user.
     */
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Method to save an user.
     * @param user to be saved.
     */
    public void save(User user) {
        userRepository.save(user);
    }

}

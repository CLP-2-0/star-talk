package edu.cs.tcu.chineselearningplatform.dao;

import edu.cs.tcu.chineselearningplatform.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);

    void deleteByUsername(String username);
}

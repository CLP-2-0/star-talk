package edu.tcu.chineselearningplatform.dao;

import edu.tcu.chineselearningplatform.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}

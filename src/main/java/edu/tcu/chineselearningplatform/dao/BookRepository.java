package edu.tcu.chineselearningplatform.dao;

import edu.tcu.chineselearningplatform.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}

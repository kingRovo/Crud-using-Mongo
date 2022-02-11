package com.rovo.mongocrud.repository;

import com.rovo.mongocrud.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User,Long> {
}

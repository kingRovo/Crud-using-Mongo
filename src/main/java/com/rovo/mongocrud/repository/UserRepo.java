package com.rovo.mongocrud.repository;

import com.rovo.mongocrud.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User,Long> {


    @Query("{id:$0}")
    Optional<User> findUserByID(Long id);



    @Query(value="{'id' : $0}", delete = true)
    User deleteUser(Long id);




}

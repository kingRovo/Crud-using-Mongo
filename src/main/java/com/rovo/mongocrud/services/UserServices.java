package com.rovo.mongocrud.services;

import com.rovo.mongocrud.model.User;
import com.rovo.mongocrud.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    UserRepo userRepo;

    public String addUser(User user){
        userRepo.save(user);
        return  "New User Added";
    }

    public List<User> displayAllUser(){
        return userRepo.findAll();
    }

    public User findUser(long id){
        return  userRepo.findById(id).orElseThrow();
    }

    public String editUser(long  id,User inputUser){

        User user = userRepo.findById(id).orElseThrow();

        user.setName(inputUser.getName());
        user.setCity(inputUser.getCity());

        userRepo.save(user);

        return  "Edit Successfully";

    }

    public String deleteUser(long id){
        User user = userRepo.findById(id).orElseThrow();
        userRepo.delete(user);

        return "User Deleted";


    }

    public String editCity(long  id,User inputUser){

        User user = userRepo.findById(id).orElseThrow();

        user.setCity(inputUser.getCity());

        userRepo.save(user);
        return "City Updated";

    }


}

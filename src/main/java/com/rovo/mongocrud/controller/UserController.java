package com.rovo.mongocrud.controller;

import com.rovo.mongocrud.model.User;
import com.rovo.mongocrud.services.SequenceGeneratorService;
import com.rovo.mongocrud.services.UserServices;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {


    @Autowired
    UserServices userServices;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;


    @PostMapping("/")
    public ResponseEntity<String> addUser(@RequestBody User user){

        try{
            user.setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
            return  new ResponseEntity<>(userServices.addUser(user), HttpStatus.CREATED);
        }
        catch (Exception e){
            return  new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/")
    public ResponseEntity<?> displayAll(){

        try{
            List<User> users = userServices.displayAllUser();
            return  new ResponseEntity<List<User>>(users,HttpStatus.OK);
        }
        catch (Exception e){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public  ResponseEntity<User> findUser(@PathVariable("id") @NonNull long  id){
        try {
            return new ResponseEntity<>(userServices.findUser(id),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editUser(@NonNull @PathVariable("id") long id,@RequestBody @NonNull User user){

        try{

            return new ResponseEntity<>(userServices.editUser(id,user),HttpStatus.OK);
        }
        catch (Exception e){

            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);

        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> editCity(@NonNull @PathVariable("id") long id, @NonNull @RequestBody User user){
        try{

            return new ResponseEntity<>(userServices.editCity(id,user),HttpStatus.OK);
        }
        catch (Exception e){

            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);

        }
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<User> deleteUser(@NonNull @PathVariable("id") long id){
        try{

            return new ResponseEntity<>(userServices.deleteUser(id),HttpStatus.OK);

        }
        catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

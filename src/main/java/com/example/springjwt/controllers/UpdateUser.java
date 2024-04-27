package com.example.springjwt.controllers;

import com.example.springjwt.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//used as password reset 
@RestController
public class UpdateUser {
    @Autowired
    ResetDatabase resetDatabase;
    @Autowired
    UserRepo userRepo;
    @GetMapping("/update/{id}")
    public void updateUserByUsername(@PathVariable int id) {
        System.out.println("Request Received for update");
        ResetRequest req= resetDatabase.findById(id).get();
        UserEntity user= userRepo.findUserEntityByUsername(req.getUsername()).get();
        user.setPassword(req.getPassword());
        userRepo.save(user);
        resetDatabase.deleteById(id);
    }


    @GetMapping("/getresetrequests")
    public List<ResetRequest> getAllUpdateRequests() {
      return  resetDatabase.findAll();
    }

}

package com.example.springjwt.controllers;

import com.example.springjwt.ResetDatabase;
import com.example.springjwt.ResetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordResetController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    ResetDatabase resetDatabase;

    @PostMapping("/resetrequest")
    void resetRequest(@RequestBody ResetRequest request){
        System.out.println("Request came");
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        resetDatabase.save(request);
        System.out.println(request.getFirstname());
        System.out.println("successfully Received Request");
    }

}

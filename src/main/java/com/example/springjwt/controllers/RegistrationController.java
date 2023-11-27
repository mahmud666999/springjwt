package com.example.springjwt.controllers;

import com.example.springjwt.RegisterDatabase;
import com.example.springjwt.RegistryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RegistrationController {

    @Autowired
    RegisterDatabase registerDatabase;

    @PostMapping("/req")
    void registrationRequest(@RequestBody RegistryRequest request){
        System.out.println("Request came");
     registerDatabase.save(request);
        System.out.println(request.getFirstname());
        System.out.println("successfully Registered");
    }

    @GetMapping("/sampleregistration")
    RegistryRequest sample(){
        return registerDatabase.findById(1).get();
    }


}

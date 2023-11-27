package com.example.springjwt.controllers;

import com.example.springjwt.RolesRepo;
import com.example.springjwt.UserEntity;
import com.example.springjwt.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/")
public class MyController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RolesRepo rolesRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @GetMapping("/getallusers")
    public List<UserEntity> userEntities(){

        return userRepo.findAll();
    }
    @GetMapping("/testing")
    public String test(){
        return "Working";
    }


    @GetMapping("/sampleuser")
    public  UserEntity sample(){
        return new UserEntity();
    }

    @PostMapping
    public void postEntities(@RequestBody UserEntity user){
        userRepo.save(user);
    }

    @GetMapping("/authenticated")
    public String authenticated(){
        return "Authenticated request";
    }


    @GetMapping("/admin")
    public String admin(){
        return "Admin Verified.";
    }

    @PostMapping("/requestaccess")
    public void userAccessRequest(@RequestBody UserEntity user){
        userRepo.save(user);
    }
}

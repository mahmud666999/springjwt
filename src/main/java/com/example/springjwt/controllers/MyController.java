package com.example.springjwt.controllers;

import com.example.springjwt.CustomRoles;
import com.example.springjwt.RolesRepo;
import com.example.springjwt.UserEntity;
import com.example.springjwt.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        UserEntity user=new UserEntity();
        user.setUsername("Test");
        user.setPassword("Hahaha");
        CustomRoles role= new CustomRoles("Testing");
        List <CustomRoles> roles= new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        return user;
    }

    @GetMapping("/current")
    public String currentUser(Authentication authentication){
        if (authentication==null) return "Not authenticated";
     List<String> list= authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
      return list.get(0);
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

package com.example.springjwt;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Populator {

    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
//Populated the admin and a test user. 
    @PostConstruct
    public void populate(){
        CustomRoles role= new CustomRoles("admin");
        UserEntity user= new UserEntity();
        user.setUsername("Mahmud");
        ArrayList<CustomRoles> roles= new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode("Test"));
        userRepo.save(user);

        UserEntity user1= new UserEntity();
        CustomRoles role1= new CustomRoles("user");
        user1.setUsername("Hassan");
        ArrayList<CustomRoles> roles1= new ArrayList<>();
        roles1.add(role1);
        user1.setRoles(roles1);
        user1.setPassword(passwordEncoder.encode("Final"));
        userRepo.save(user1);


    }
}

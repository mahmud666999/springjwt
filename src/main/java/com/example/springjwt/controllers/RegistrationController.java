package com.example.springjwt.controllers;

import com.example.springjwt.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RegistrationController {

    @Autowired
    RegisterDatabase registerDatabase;
    @Autowired
    UserRepo userRepo;
    @Autowired
    RolesRepo rolesRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    FeedbackDatabase feedbackDatabase;

    @PostMapping("/req")
    void registrationRequest(@RequestBody RegistryRequest request){
        System.out.println("Request came");
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        registerDatabase.save(request);
        System.out.println(request.getFirstname());
        System.out.println("successfully Registered");
    }



    @GetMapping("/sampleregistration")
    RegistryRequest sample(){
        return registerDatabase.findById(1).get();
    }

    @GetMapping("/getregistryrequests")
    public List<RegistryRequest> userEntities(){

        return registerDatabase.findAll();
    }

    @GetMapping("/onlyregistered")
    public String regtest(){

        return "Registered User";
    }

    @GetMapping("/registration")
    public String tester(){
        return "This is working lol";

    }
    @GetMapping("/permit/{id}")
    public void getEmployeesById(@PathVariable int id) {
       RegistryRequest req= registerDatabase.findById(id).get();
        UserEntity user= new UserEntity();
        user.setUsername(req.getUsername());
        user.setPassword(req.getPassword());
        ArrayList<CustomRoles> roles= new ArrayList<>();
        roles.add(rolesRepo.findById(2).get());
        user.setRoles(roles);
        user.setPassword(req.getPassword());
        userRepo.save(user);
        registerDatabase.deleteById(id);
    }




    @GetMapping(value = "/username")
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }

}

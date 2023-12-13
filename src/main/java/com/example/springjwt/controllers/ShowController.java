package com.example.springjwt.controllers;

import com.example.springjwt.Show;
import com.example.springjwt.details.ShowDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ShowController {

    @Autowired
    ShowDatabase showDatabase;

    @PostMapping("/uploadshow")
    public void handleShowUpload(@RequestBody Show show){
        showDatabase.save(show);
    }
    @GetMapping("/requestbooking/{id}")
    public void requestbooking(@PathVariable int id){

    }


}


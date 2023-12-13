package com.example.springjwt.controllers;

import com.example.springjwt.Feedback;
import com.example.springjwt.FeedbackDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class FeedbackController {

    @Autowired
    FeedbackDatabase feedbackDatabase;

    @PostMapping("/feedbackpost")
    void feedbackRequest(@RequestBody Feedback feedback){
        feedbackDatabase.save(feedback);
    }


    @GetMapping("/getallfeedbacks")
    public List<Feedback> allfeedbacks(){
        return feedbackDatabase.findAll();

    }

    @GetMapping("/samplefeedback")
    public Feedback getFeedbacks(){
      Feedback feedback= new Feedback(1,"Sample feedback");
      return feedback;

    }
}

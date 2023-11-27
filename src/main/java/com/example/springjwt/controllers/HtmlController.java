package com.example.springjwt.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

@Controller

public class HtmlController {
    @GetMapping("/index")
    public ModelAndView index () {
        ModelAndView modelandview = new ModelAndView();
        modelandview.setViewName("index.html");
        return modelandview;
    }

    @GetMapping("/data")
    public ModelAndView registration() {
        ModelAndView modelandview = new ModelAndView();
        modelandview.setViewName("registration.html");
        return modelandview;
    }

}
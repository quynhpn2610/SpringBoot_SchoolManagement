package com.springbootproject1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class HomeController { //localhost:8080/

    @GetMapping
    public ModelAndView showHomePage(){
        ModelAndView homePage = new ModelAndView("/homepage");
        return homePage;
    }
}

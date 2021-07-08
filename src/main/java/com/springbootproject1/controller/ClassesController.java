package com.springbootproject1.controller;

import com.springbootproject1.model.Classes;
import com.springbootproject1.service.classes.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private IClassesService classesService;

    @GetMapping("/classes-list")
    public ModelAndView getAllClasses(){
        Iterable<Classes> classes = classesService.findAll();
        ModelAndView modelAndView = new ModelAndView("/classes/classes-list");
        modelAndView.addObject("classes", classes);
        return modelAndView;
    }
}

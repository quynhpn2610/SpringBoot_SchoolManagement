package com.springbootproject1.controller;

import com.springbootproject1.model.Classes;
import com.springbootproject1.service.classes.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/add-class")
    public ModelAndView showAddForm() {
        ModelAndView addForm = new ModelAndView("/classes/add-class");
        addForm.addObject("class", new Classes());
        return addForm;
    } // SOLID -> Single Responsiblity

    @PostMapping("/add-class")
    public ModelAndView saveClass(@ModelAttribute Classes classes) {
        classesService.save(classes);
        ModelAndView addForm = new ModelAndView("/classes/add-class");
        addForm.addObject("class", new Classes());
        return addForm;
    }
}

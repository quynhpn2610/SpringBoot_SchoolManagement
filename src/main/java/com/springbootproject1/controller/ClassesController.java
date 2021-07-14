package com.springbootproject1.controller;

import com.springbootproject1.model.Classes;
import com.springbootproject1.service.classes.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/update/{id}")
    public ModelAndView showUpdateForm(@PathVariable Long id) {
        Optional<Classes> classesOptional = classesService.findById(id);
        ModelAndView modelAndView;
        if (classesOptional.isPresent()) {
            modelAndView = new ModelAndView("/classes/classes-update");
            modelAndView.addObject("class", classesOptional.get());
        }
        else {
            modelAndView = new ModelAndView("404-notfound");
        }
        return modelAndView;
    }

    @PostMapping("/update")
    public String updateClass(@ModelAttribute Classes classes) {
        classesService.save(classes);
        return "redirect:/classes/classes-list";
    }
}

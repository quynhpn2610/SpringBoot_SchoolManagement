package com.springbootproject1.controller;

import com.springbootproject1.model.Classes;
import com.springbootproject1.model.Student;
import com.springbootproject1.service.classes.IClassesService;
import com.springbootproject1.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller //return View
// Rest Controller --> object (json)
@RequestMapping("/student") // chuyen cac request /student vao day roi xu li // localhost:8080/student/student-list
public class StudentController {

    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClassesService classesService;

    @GetMapping("/student-list") // RESTful APIs GET POST PUT DELETE PATCH
    public ModelAndView getAllStudents() {
        Iterable<Student> students = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView("/student/student-list");
        modelAndView.addObject("pupils", students);
        return modelAndView;
    }

    @GetMapping("/add-student")
    public ModelAndView showAddForm(){
        Iterable<Classes> classes = classesService.findAll();
        ModelAndView addForm = new ModelAndView("student/add-student");
        addForm.addObject("student", new Student());
        addForm.addObject("classes", classes);
        return addForm;
    }

    @PostMapping("/add-student")
    public ModelAndView saveStudent(@ModelAttribute Student student){
        Iterable<Classes> classes = classesService.findAll();
        studentService.save(student);
        // Quay ve form addForm rong de dien tiep
        ModelAndView addForm = new ModelAndView("/student/add-student");
        addForm.addObject("student", new Student());
        addForm.addObject("classes", classes);
        return addForm;
    }

    @GetMapping("/update/{student_id}")
    public ModelAndView showUpdateForm(@PathVariable Long student_id){
        Optional<Student> studentOptional = studentService.findById(student_id);
        Iterable<Classes> classesIterable = classesService.findAll();
        ModelAndView modelAndView;
        if (studentOptional.isPresent()){
            modelAndView = new ModelAndView("/student/student-update");
            modelAndView.addObject("student", studentOptional.get());
            modelAndView.addObject("classes", classesIterable);
        }
        else{
            modelAndView = new ModelAndView("404-notfound");
        }
        return modelAndView;
    }

    @PostMapping("/student-update")
    public String updateStudent(@ModelAttribute Student student){
        studentService.save(student);
        return "redirect:/student/student-list";
    }

    @GetMapping("/delete/{student_id}")
    // deletebyId instead of findById
    // return a string line 71
    public String deleteStudent(@PathVariable Long student_id){
        studentService.deleteById(student_id);
        return "redirect:/student/student-list";
    }

}

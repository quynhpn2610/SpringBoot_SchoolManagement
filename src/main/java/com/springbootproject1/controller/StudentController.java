package com.springbootproject1.controller;

import com.springbootproject1.model.Student;
import com.springbootproject1.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student") // chuyen cac request /student vao day roi xu li
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("/student-list")
    public ModelAndView getAllStudents() {
        Iterable<Student> students = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView("/student/student-list");
        modelAndView.addObject("students", students);
        return modelAndView;
    }
}

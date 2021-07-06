package com.springbootproject1.service.student;

import com.springbootproject1.model.Student;
import com.springbootproject1.service.IGeneralService;
import org.springframework.stereotype.Service;

@Service
public interface IStudentService extends IGeneralService<Student> {
}

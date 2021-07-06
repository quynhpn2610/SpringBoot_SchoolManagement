package com.springbootproject1.service.student;

import com.springbootproject1.model.Student;
import com.springbootproject1.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentService implements IStudentService {

    @Autowired // dependency injection using bean factory
    private IStudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.getAllStudent();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteStudentById(id);
    }
}

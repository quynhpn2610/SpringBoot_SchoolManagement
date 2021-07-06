package com.springbootproject1.repository;

import com.springbootproject1.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository {

    @Query(value = "select * from student", nativeQuery = true)
    Iterable<Student> getAllStudent();

    @Query(value = "select * from student where id = id", nativeQuery = true)
    Student getStudentById(Long id);

    @Query(value = "insert into student (name, age) values(student.name, student.age)", nativeQuery = true)
    Student save(Student student);

    @Query(value = "delete from student where id = id",nativeQuery = true)
    void deleteStudentById(Long id);
}

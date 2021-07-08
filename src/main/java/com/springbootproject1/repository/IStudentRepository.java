package com.springbootproject1.repository;

import com.springbootproject1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //to let springboot knows it has to create beans for later use of dependency injection
// Jpa: a library to generate basic SQL CRUD queries (format: java func). Parameter: the object you want to CRUD
// and its primary key data type
public interface IStudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "select * from student", nativeQuery = true) //nativeQuery: to let java know what is written before is SQL queries
    Iterable<Student> findAllStudents();

    @Query(value = "select * from student where id = id", nativeQuery = true)
    Optional<Student> findById(Long id);
    //Optional - to handle when database has problems (object found by id null)
    //In controller: if null -> return not found. Without Optional, exception detected before the program enters controller.

    @Query(value = "insert into student (name, age) values(student.name, student.age)", nativeQuery = true)
    //student(name, age) là bảng student có 2 cột name and age được ORM tạo ra
    Student save(Student student);

    @Query(value = "delete from student where id = id",nativeQuery = true)
    void deleteById(Long id);
}

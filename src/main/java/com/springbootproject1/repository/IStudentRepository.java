package com.springbootproject1.repository;

import com.springbootproject1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "select * from student", nativeQuery = true)
    Iterable<Student> findAllStudents();

    @Query(value = "select * from student where id = id", nativeQuery = true)
    Optional<Student> findById(Long id);

    @Query(value = "insert into student (name, age) values(student.name, student.age)", nativeQuery = true)
    Student save(Student student);

    @Query(value = "delete from student where id = id",nativeQuery = true)
    void deleteById(Long id);
}

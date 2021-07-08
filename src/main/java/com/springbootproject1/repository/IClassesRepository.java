package com.springbootproject1.repository;

import com.springbootproject1.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClassesRepository extends JpaRepository<Classes, Long> {
    // Auto generated queries
    // Write it yourself is ok
    @Query(value = "select * from classes", nativeQuery = true)
    Iterable<Classes> findAllClasses();

    @Query(value = "select * from classes where id = id", nativeQuery = true)
    Optional<Classes> findById(Long id);

    @Query(value = "insert into classes (level, rate) values(classes.level, classes.rate)", nativeQuery = true)
    Classes save(Classes classes);

    @Query(value = "delete from classes where id = id_", nativeQuery = true)
    void deleteById(Long id_);
}

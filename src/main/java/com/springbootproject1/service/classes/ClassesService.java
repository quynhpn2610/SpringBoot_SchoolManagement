package com.springbootproject1.service.classes;

import com.springbootproject1.model.Classes;
import com.springbootproject1.repository.IClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassesService implements IClassesService{
    @Autowired
    private IClassesRepository classesRepository;

    @Override
    public Classes save(Classes classes) {
        return classesRepository.save(classes);
    }

    @Override
    public Iterable<Classes> findAll() {
        return classesRepository.findAllClasses();
    }

    @Override
    public Optional<Classes> findById(Long id) {
        return classesRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        classesRepository.deleteById(id);
    }
}

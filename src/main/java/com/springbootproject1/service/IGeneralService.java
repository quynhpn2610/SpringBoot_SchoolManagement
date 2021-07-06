package com.springbootproject1.service;

import org.springframework.stereotype.Service;

import java.util.Optional;

public interface IGeneralService<T> {
    T save (T t);

    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void deleteById(Long id);
}

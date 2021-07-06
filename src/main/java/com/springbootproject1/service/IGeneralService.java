package com.springbootproject1.service;

import org.springframework.stereotype.Service;

@Service
public interface IGeneralService<T> {
    T save (T t);

    Iterable<T> findAll();

    T findById(Long id);

    void deleteById(Long id);
}

package com.venkat.service;

import com.venkat.model.Product;

import java.util.List;
import java.util.Optional;

public interface MyDao<T> {

    List<T> getAll();
    Product create(T t);
    Optional<T> get(int id);
    Product update(T t, int id);
    boolean delete(int id);
}

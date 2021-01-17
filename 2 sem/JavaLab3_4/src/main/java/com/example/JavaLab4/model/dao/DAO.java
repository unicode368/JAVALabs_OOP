package com.example.JavaLab4.model.dao;

import java.util.ArrayList;

public interface DAO<T> {
    ArrayList<T> getAll();
    T get(int i);
    void set();
}

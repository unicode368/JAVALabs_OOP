package com.example.JavaLab4.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO<T> {
    ArrayList<T> getAll() throws SQLException;
    T get(int i);
    void set();
}

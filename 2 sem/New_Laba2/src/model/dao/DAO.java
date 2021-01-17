package model.dao;

import model.Book;
import model.ObjectType;

import java.util.ArrayList;

public interface DAO<T> {
    ArrayList<T> getAll();
    T get(int i);
    void set();
}

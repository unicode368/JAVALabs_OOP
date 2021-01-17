package com.example.JavaLab4.model.dao;

import com.example.JavaLab4.model.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO implements DAO {

    private Storage books;
    private Connection db;

    public BookDAO() throws SQLException, ClassNotFoundException {
        books = new Storage();
        Class.forName("org.postgresql.Driver");
        db = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library",
                "postgres", "Sobak@234");
    }

    @Override
    public ArrayList<Book> getAll() {
        return books.getBooks();
    }

    public void add(Book book) {
        books.getBooks().add(book);
    }

    public void delete(int i) {
        books.getBooks().remove(i);
    }

    @Override
    public Book get(int i) {
        return books.getBooks().get(i);
    }

    @Override
    public void set() {

    }
}

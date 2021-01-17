package com.example.JavaLab4.model.service;

import com.example.JavaLab4.model.dao.Storage;
import com.example.JavaLab4.model.user.User;
import com.example.JavaLab4.model.Book;

import java.sql.SQLException;

public class LibrarianService extends Service {

    private User librarian;
 //   private UserDAO dao;

    public LibrarianService(User librarian) throws SQLException, ClassNotFoundException {
        this.librarian = librarian;
//        this.dao = dao;
    }

    public void giveBook(Storage storage, Book book) {

    }

}

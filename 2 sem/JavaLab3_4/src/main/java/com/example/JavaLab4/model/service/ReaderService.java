package com.example.JavaLab4.model.service;

import com.example.JavaLab4.model.user.Reader;

import java.sql.SQLException;

public class ReaderService extends Service {

    private Reader reader;
//    private BookDAO dao;

    public ReaderService(Reader reader) throws SQLException, ClassNotFoundException {
        this.reader = reader;
//        this.dao = dao;
    }

}

package com.example.JavaLab4.model.dao;

import com.example.JavaLab4.model.Book;
import com.example.JavaLab4.model.Date;
import com.example.JavaLab4.model.SearchOption;
import com.example.JavaLab4.model.SortOption;
import com.example.JavaLab4.model.user.User;
import com.example.JavaLab4.model.user.UserType;

import java.sql.*;
import java.util.ArrayList;

public class BookDAO implements DAO {

    private Connection db;

    public BookDAO() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        db = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library",
                "postgres", "Sobak@234");
    }

    @Override
    public ArrayList<Book> getAll() throws SQLException {
        ArrayList<Book> books = new ArrayList<>();
        Statement statement = db.createStatement();
        ResultSet query = statement.executeQuery("SELECT * FROM books");
        while (query.next()) {
            books.add(new Book(query.getInt("id"),
                    query.getString("name"),
                    query.getString("author"),
                    query.getString("edition"),
                    new Date(query.getString("date")),
                    query.getInt("amount")));
        }
        return books;
    }

    public void add(Book book) {
 //       books.getBooks().add(book);
    }

    public void delete(int i) {
 //       books.getBooks().remove(i);
    }

    @Override
    public Book get(int i) {
//        return books.getBooks().get(i);
        return null;
    }

    public ArrayList<Book> get(String search_parameter, SearchOption option) throws SQLException {
        ArrayList<Book> books = new ArrayList<>();
        PreparedStatement ps;
        if (option == SearchOption.NAME) {
            String query = "SELECT * FROM books WHERE name=?";
            ps = db.prepareStatement(query);
            ps.setString(1, search_parameter);
        } else {
            String query = "SELECT * FROM books WHERE author=?";
            ps = db.prepareStatement(query);
            ps.setString(1, search_parameter);
        }
        ResultSet search = ps.executeQuery();
        while (search.next()) {
            books.add(new Book(search.getInt("id"),
                    search.getString("name"),
                    search.getString("author"),
                    search.getString("edition"),
                    new Date(search.getString("date")),
                    search.getInt("amount")));
        }
        return books;
    }

    @Override
    public void set() {

    }

    public ArrayList<Book> getSorted(String sortOption) throws SQLException {
        ArrayList<Book> books = new ArrayList<>();
        Statement statement = db.createStatement();
        ResultSet query = statement.executeQuery("SELECT * FROM books ORDER BY name");;
        switch (sortOption) {
            case "name":
                query = statement.executeQuery("SELECT * FROM books ORDER BY name");
                break;
            case "author":
                query = statement.executeQuery("SELECT * FROM books ORDER BY author");
                break;
            case "edition":
                query = statement.executeQuery("SELECT * FROM books ORDER BY edition");
                break;
            case "date":
                query = statement.executeQuery("SELECT * FROM books ORDER BY date");
                break;
        }
        while (query.next()) {
            books.add(new Book(query.getInt("id"),
                    query.getString("name"),
                    query.getString("author"),
                    query.getString("edition"),
                    new Date(query.getString("date")),
                    query.getInt("amount")));
        }
        return books;
    }
}

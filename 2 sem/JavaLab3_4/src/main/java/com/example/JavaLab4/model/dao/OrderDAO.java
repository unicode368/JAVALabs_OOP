package com.example.JavaLab4.model.dao;

import com.example.JavaLab4.model.Book;
import com.example.JavaLab4.model.Date;
import com.example.JavaLab4.model.Order;

import java.sql.*;
import java.util.ArrayList;

public class OrderDAO implements DAO {

    private Connection db;

    public OrderDAO() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        db = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library",
                "postgres", "Sobak@234");
    }

    @Override
    public ArrayList<Order> getAll() throws SQLException {
        ArrayList<Order> orders = new ArrayList<>();
        Statement statement = db.createStatement();
        ResultSet query = statement.executeQuery("SELECT users.login AS reader_login, t1.login AS \n" +
                "librarian_login, books.id, books.name, books.author, books.edition, \n" +
                "books.date AS edition_date, books.amount, \n" +
                "orders.date, orders.returndate FROM orders\n" +
                "JOIN users ON orders.reader_id = users.id\n" +
                "JOIN (SELECT * FROM users) AS t1\n" +
                "ON orders.librarian_id = t1.id\n" +
                "JOIN books ON orders.book_id = books.id");
        while (query.next()) {
            orders.add(new Order(query.getString("reader_login"),
                       query.getString("librarian_login"),
                       new Book(query.getInt("id"),
                            query.getString("name"),
                            query.getString("author"),
                            query.getString("edition"),
                            new Date(query.getString("edition_date")),
                            query.getInt("amount")),
                       new Date(query.getString("date")),
                       new Date(query.getString("returndate"))));
        }
        return orders;
    }

    @Override
    public Object get(int i) {
        return null;
    }

    @Override
    public void set() {

    }
}

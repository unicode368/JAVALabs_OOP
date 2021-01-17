package model.dao;

import model.Book;

import java.util.ArrayList;

public class BookDAO implements DAO {

    private Storage books;

    public BookDAO() {
        books = new Storage();
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
        return null;
    }

    @Override
    public void set() {

    }
}

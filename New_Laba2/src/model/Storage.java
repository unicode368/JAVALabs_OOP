package model;

import java.util.ArrayList;

public class Storage {

    ArrayList<Book> books;

    public Storage() {
        books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void add(String[] book) {
        books.add(new Book(book[0], book[1], book[2], new Date(book[3])));
    }

    public void remove(int number) {
        books.remove(number);
    }

    public void edit(int number, String[] info) {
        books.get(number).setName(info[0]);
        books.get(number).setAuthor(info[1]);
        books.get(number).setEdition(info[2]);
        books.get(number).setDate(new Date(info[3]));
    }

    public Book searchBook(Book book) {
        for (int i = 0; i < books.size(); i++) {

        }
    }
}

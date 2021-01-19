package com.example.JavaLab4.model;

public class Order {

    private String reader;
    private String librarian;
    private Book book;
    private Date date;
    private Date returnDate;

    public Order(String reader, String librarian, Book book,
                 Date date, Date returnDate) {
        this.reader = reader;
        this.librarian = librarian;
        this.book = book;
        this.date = date;
        this.returnDate = returnDate;
    }

    public String getReaderId() {
        return reader;
    }

    public String getLibrarian() {
        return librarian;
    }

    public Book getBook() {
        return book;
    }

    public Date getDate() {
        return date;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReaderId(String reader_id) {
        this.reader = reader_id;
    }

    public void setLibrarian(String librarian) {
        this.librarian = librarian;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}

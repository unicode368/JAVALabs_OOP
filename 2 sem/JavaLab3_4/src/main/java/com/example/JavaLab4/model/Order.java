package com.example.JavaLab4.model;

public class Order {

    private int reader_id;
    private int librarian;
    private int book;
    private Date date;
    private Date returnDate;

    public Order(int reader_id, int librarian, int book, Date date, Date returnDate) {
        this.reader_id = reader_id;
        this.librarian = librarian;
        this.book = book;
        this.date = date;
        this.returnDate = returnDate;
    }

    public int getReaderId() {
        return reader_id;
    }

    public int getLibrarian() {
        return librarian;
    }

    public int getBook() {
        return book;
    }

    public Date getDate() {
        return date;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReaderId(int reader_id) {
        this.reader_id = reader_id;
    }

    public void setLibrarian(int librarian) {
        this.librarian = librarian;
    }

    public void setBook(int book) {
        this.book = book;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}

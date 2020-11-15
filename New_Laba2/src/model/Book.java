package model;

import java.util.Random;

public class Book {
    private String name;
    private String author;
    private String edition;
    private Date date;
    private int amount;

    public Book(String name, String author, String edition, Date date) {
        this.name = name;
        this.author = author;
        this.edition = edition;
        this.date = date;
        amount = new Random().nextInt(10) + 1;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getEdition() {
        return edition;
    }

    public Date getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}

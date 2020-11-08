package service;

import model.Book;
import model.Storage;
import model.user.Librarian;

public class LibrarianService extends Service {

    Librarian librarian;

    LibrarianService(Librarian librarian) {
        this.librarian = librarian;
    }

    public void giveBook(Storage storage, Book book) {

    }

}

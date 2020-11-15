package util;

import model.Book;
import model.user.User;

import java.util.ArrayList;

public class Tools {

    private BookComparator bookComparator;
    private UserComparator userComparator;

    public Tools() {
        bookComparator = new BookComparator();
        userComparator = new UserComparator();
    }

    public Book searchBook(Book book, ArrayList<Book> books) {
        for (int i = 0; i < books.size(); i++) {
            if (bookComparator.equal(book, books.get(i))) {
                return books.get(i);
            }
        }
        return null;
    }

    public User searchUser(String login, String password, ArrayList<User> users) {
        for (int i = 0; i < users.size(); i++) {
            if (userComparator.equal(login, password, users.get(i))) {
                return users.get(i);
            }
        }
        return null;
    }
}

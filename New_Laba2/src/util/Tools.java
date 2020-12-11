package util;

import model.Book;
import model.ObjectType;
import model.user.User;
import java.util.ArrayList;
import java.util.Comparator;

public class Tools<T> {

    ObjectType objectType;

    public Tools(ObjectType objectType) {
        this.objectType = objectType;
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

    public T search(Book book) {

    }

    @Override
    public int compare(T o1, T o2) {
        return 0;
    }

}

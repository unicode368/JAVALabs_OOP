package util;

import model.Book;

import java.util.Comparator;

public class BookComparator implements Comparator<T> {

    public int compare(Object o1, Object o2) {
        return 0;
    }

    public boolean equal(Book b1, Book b2) {
        if (b1.getName().equals(b2.getName()) &&
                b1.getAuthor().equals(b2.getAuthor()) &&
                b1.getEdition().equals(b2.getEdition()) &&
                b1.getDate().equal(b1.getDate(), b2.getDate())) {
            return true;
        }
        return false;
    }

    @Override
    public int compare(T o1, T o2) {
        return 0;
    }
}

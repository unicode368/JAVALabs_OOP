package util;

import model.Book;
import model.ObjectType;
import model.user.User;
import java.util.ArrayList;
import java.util.Comparator;

public class Tools<T> {

    ObjectType objectType;
    Comparator comparator;

    public Tools(ObjectType objectType) {
        this.objectType = objectType;
        switch (objectType) {
            case USER: comparator = new BookComparator();
            break;
            case BOOK: comparator = new UserComparator();
            break;
        }
    }

    public T search(T obj, ArrayList<T> dao) {
        for (int i = 0; i < dao.size(); i++) {
            if (obj.equals(dao.get(i))) {
                return obj;
            }
        }
        return null;
    }

/*    @Override
    public int compare(T o1, T o2) {
        return 0;
    }*/

}

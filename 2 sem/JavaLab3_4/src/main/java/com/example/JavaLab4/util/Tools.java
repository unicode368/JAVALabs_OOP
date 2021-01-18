package com.example.JavaLab4.util;

import com.example.JavaLab4.model.*;
import com.example.JavaLab4.model.dao.BookDAO;
import com.example.JavaLab4.model.dao.DAO;
import com.example.JavaLab4.model.dao.UserDAO;
import com.example.JavaLab4.model.user.User;

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

    public ArrayList<T> search(T obj, DAO<T> dao) {
        ArrayList<T> found = new ArrayList<>();
/*        for (int i = 0; i < dao.size(); i++) {
            if (obj.equals(dao.get(i))) {
                found.add(dao.get(i));
            }
        }*/
        return found;
    }

    public ArrayList<T> search(SearchOption type, ObjectType objectType, String name, DAO<T> dao) {
  /*      ArrayList<T> found = new ArrayList<>();
        if (objectType == ObjectType.BOOK) {
            BookDAO bookDAO = (BookDAO) dao;
            if (type == SearchOption.NAME) {
                for (int i = 0; i < bookDAO.getAll().size(); i++) {
                    if (bookDAO.get(i).getName().equals(name)) {
                        found.add(dao.get(i));
                    }
                }
            } else {
                for (int i = 0; i < bookDAO.getAll().size(); i++) {
                    if (bookDAO.get(i).getAuthor().equals(name)) {
                        found.add(dao.get(i));
                    }
                }
            }
        }
        return found;*/
        return null;
    }



/*    @Override
    public int compare(T o1, T o2) {
        return 0;
    }*/

}

package controller;

import model.Book;
import model.user.User;

import java.util.ArrayList;

public class Converter {

    private ArrayList<?> list;

    Converter(ArrayList<?> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        StringBuilder result1 = new StringBuilder();
        int amount = list.size();
        if (amount == 0) {
            return "Записи відсутні. ";
        }
        result1.append("\n").append(String.format("%s","-----------------------------------------------" +
                "--------------------------------------------------------------------------------" +
                "-----------------------------------------")).append("\n");
        for (int counter = 0; counter <= amount; counter = counter + 3) {
            if (amount - 1 - counter < 3) {
                result1.append(objectInfo(list, amount - counter, counter));
                result1.append("\n").append(String.format("%s","-----------------------------------------------" +
                        "--------------------------------------------------------------------------------" +
                        "-----------------------------------------"));
                break;
            } else {
                result1.append(objectInfo(list,3, counter)).append("\n");
                result1.append("\n").append(String.format("%s","-----------------------------------------------" +
                        "--------------------------------------------------------------------------------" +
                        "-----------------------------------------")).append("\n");
            }
        }
        return result1.toString();
    }

    public String objectInfo(ArrayList<?> objects, int size, int start) {
        if (isListOf(objects, Book.class)) {
            return getRow(objects, size, start, "BookName") + "\n" +
                    getRow(objects, size, start, "BookAuthor") + "\n" +
                    getRow(objects, size, start, "BookEdition") + "\n" +
                    getRow(objects, size, start, "EditionData");
        } else {
            return getRow(objects, size, start, "login") + "\n" +
                    getRow(objects, size, start, "password") + "\n" +
                    getRow(objects, size, start, "role") + "\n" +
                    getRow(objects, size, start, "blocked");
        }

    }

    public String getRow(ArrayList<?> objects, int size, int start, String kindOfInfo) {
        String row = "";
        if(isListOf(objects, Book.class)) {
            ArrayList<Book> books = (ArrayList<Book>) objects;
            switch (kindOfInfo) {
                case "BookName" :
                    for (int i = start; i < size + start; i++) {
                        row += String.format("%30s %25s", (i + 1) + ". " +
                                "Назва книги: " + books.get(i).getName(), "|");
                    }
                    break;
                case "BookAuthor" :
                    for (int i = start; i < size + start; i++) {
                        row += String.format("%30s %25s","Автор: " + books.get(i).getAuthor(),
                                "|");
                    }
                    break;
                case "BookEdition" :
                    for (int i = start; i < size + start; i++) {
                        row += String.format("%30s %25s","Видавництво: " + books.get(i).getEdition(),
                                "|");
                    }
                    break;
                case "EditionData" :
                    for (int i = start; i < size + start; i++) {
                        row += String.format("%30s %25s","Дата видання: " +
                                books.get(i).getDate().toString(), "|");
                    }
                    break;
            }
            return row;
        } else {
            ArrayList<User> users = (ArrayList<User>) objects;
            switch (kindOfInfo) {
                case "login" :
                    for (int i = start; i < size + start; i++) {
                        row += String.format("%30s %25s", (i + 1) + ". " +
                                "Логін: " + users.get(i).getLogin(), "|");
                    }
                    break;
                case "password" :
                    for (int i = start; i < size + start; i++) {
                        row += String.format("%30s %25s","Пароль: " + users.get(i).getPassword(),
                                "|");
                    }
                    break;
                case "role" :
                    for (int i = start; i < size + start; i++) {
                        row += String.format("%30s %25s","Роль: " +
                                        users.get(i).getRole(), "|");
                    }
                    break;
                case "blocked" :
                    for (int i = start; i < size + start; i++) {
                        row += String.format("%30s %25s","Заблоковано: " +
                                String.valueOf(users.get(i).getBlocked()), "|");
                    }
                    break;
            }
            return row;
        }
    }

    public boolean isListOf(ArrayList<?> list, Class<?> c) {
        for (Object o : list) {
            if (!c.isInstance(o)) return false;
        }
        return true;
    }



}

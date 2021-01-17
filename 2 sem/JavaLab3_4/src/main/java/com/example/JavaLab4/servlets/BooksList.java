package com.example.JavaLab4.servlets;

import com.example.JavaLab4.model.Book;
import com.example.JavaLab4.model.ObjectType;
import com.example.JavaLab4.model.SearchOption;
import com.example.JavaLab4.model.service.Service;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "bookList", value = "/bookList")
public class BooksList extends HttpServlet {

    public Service service;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        try {
            service = new Service();
        } catch (SQLException|ClassNotFoundException e) {

        }
        ArrayList<Book> list = service.getBookDAO().getAll();
        request.setAttribute("search", false);
        request.setAttribute("booklist", list);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        try {
            service = new Service();
        } catch (SQLException|ClassNotFoundException e) {

        }
        ArrayList<Book> list;
        req.setCharacterEncoding("UTF-8");
        if (req.getParameter("search-type").equals("name")) {
            list = service.getBookTools().search(SearchOption.NAME, ObjectType.BOOK,
                    req.getParameter("search"), service.getBookDAO());
        } else {
            list = service.getBookTools().search(SearchOption.AUTHOR, ObjectType.BOOK,
                    req.getParameter("search"), service.getBookDAO());
        }
        req.setAttribute("search", true);
        req.setAttribute("booklist", list);
        resp.sendRedirect(req.getContextPath() + "/");
    }
}

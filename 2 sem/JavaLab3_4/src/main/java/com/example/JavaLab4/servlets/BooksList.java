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
        ArrayList<Book> list = new ArrayList<>();
        try {
            service = new Service();
            list = service.getBookDAO().getAll();
        } catch (SQLException|ClassNotFoundException e) {

        }
        request.setAttribute("search", false);
        request.setAttribute("booklist", list);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        ArrayList<Book> list = new ArrayList<>();
        req.setCharacterEncoding("UTF-8");
        try {
            service = new Service();
            if (req.getParameter("search-type").equals("name")) {
                list = service.getBookDAO().get(req.getParameter("search"),
                        SearchOption.NAME);
            } else {
                list = service.getBookDAO().get(req.getParameter("search"),
                        SearchOption.AUTHOR);
            }
        } catch (SQLException|ClassNotFoundException e) {

        }
        req.setAttribute("search", true);
        req.setAttribute("booklist", list);
        resp.sendRedirect(req.getContextPath() + "/");
    }
}

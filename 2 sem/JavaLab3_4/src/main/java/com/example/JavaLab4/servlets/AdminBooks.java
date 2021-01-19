package com.example.JavaLab4.servlets;

import com.example.JavaLab4.model.Book;
import com.example.JavaLab4.model.SearchOption;
import com.example.JavaLab4.model.service.AdminService;
import com.example.JavaLab4.model.service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "adminBooks", value = "/adminBooks")
public class AdminBooks extends HttpServlet {

    public AdminService service;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
/*        ArrayList<Book> list = new ArrayList<>();
        try {
            service = new Service();
            list = service.getBookDAO().getAll();
        } catch (SQLException |ClassNotFoundException e) {

        }
        request.setAttribute("search", false);
        request.setAttribute("booklist", list);*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        ArrayList<Book> list = new ArrayList<>();
        if (!req.getParameter("edit").equals("")) {
            try {
                service = new AdminService();
                service.getBookDAO().delete(Integer.parseInt(req.getParameter("edit")));
                list = service.getBookDAO().getAll();
            } catch (SQLException|ClassNotFoundException e) {

            }
        } else if (!req.getParameter("delete").equals("")) {
            try {
                service = new AdminService();
                service.getBookDAO().delete(Integer.parseInt(req.getParameter("delete")));
                list = service.getBookDAO().getAll();
            } catch (SQLException|ClassNotFoundException e) {

            }
        }
        req.setAttribute("booklist", list);
        resp.sendRedirect(req.getContextPath() + "/");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
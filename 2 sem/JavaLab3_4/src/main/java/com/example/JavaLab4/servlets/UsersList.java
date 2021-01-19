package com.example.JavaLab4.servlets;

import com.example.JavaLab4.model.service.AdminService;
import com.example.JavaLab4.model.service.Service;
import com.example.JavaLab4.model.user.User;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "userList", value = "/userList")
public class UsersList extends HttpServlet {

    public AdminService service;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        ArrayList<User> list = new ArrayList<>();
        try {
            service = new AdminService();
            list = service.getUserDAO().getAll();
        } catch (SQLException|ClassNotFoundException e) {

        }
//        request.setAttribute("search", false);
        request.setAttribute("userlist", list);
        request.getRequestDispatcher("/jsp/users-list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
           ServletException, IOException {
  /*       try {
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
        resp.sendRedirect(req.getContextPath() + "/");*/
    }
}
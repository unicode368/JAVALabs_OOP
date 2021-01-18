package com.example.JavaLab4.servlets;

import com.example.JavaLab4.model.Book;
import com.example.JavaLab4.model.service.Service;
import com.example.JavaLab4.model.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet(name = "loginPage", value = "/login")
public class LoginPage extends HttpServlet {

    public Service service;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = null;
        try {
            service = new Service();
            user = service.getUserDAO().get(username, password);
        } catch (SQLException|ClassNotFoundException e) {
            System.exit(1);
        } catch (IndexOutOfBoundsException e) {
            req.setAttribute("error", "Unknown login, try again");
            doGet(req, resp);
        }
        req.getSession().setAttribute("user", user);
        resp.sendRedirect(req.getContextPath() + "/");

    }
}

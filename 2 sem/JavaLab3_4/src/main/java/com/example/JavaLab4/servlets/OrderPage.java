package com.example.JavaLab4.servlets;

import com.example.JavaLab4.model.service.Service;
import com.example.JavaLab4.model.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "orderPage", value = "/orders")
public class OrderPage extends HttpServlet {

    public Service service;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/jsp/reader-orders.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*String username = req.getParameter("username");
        String password = req.getParameter("password");
        service = new Service();
        User user = service.getUserTools().search(new User(username, password),
                service.getUserDAO().getAll());
        if (user != null) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            req.setAttribute("error", "Unknown login, try again");
            doGet(req, resp);
        }*/
    }
}

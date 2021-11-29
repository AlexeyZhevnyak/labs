package com.example.lab7;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "authServlet", value = "/authServlet")
public class AuthServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceDb.init("lab7", "root", "1111");
        UserDaoDBImpl userDaoDB = new UserDaoDBImpl();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean registered = userDaoDB.isRegistered(email, password);
        getServletContext().getRequestDispatcher("/contentServlet").forward(request, response);
    }
}

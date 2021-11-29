package com.example.lab7;

import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "regServlet", value = "/reg")
public class RegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceDb.init("lab7", "root", "1111");
        UserDaoDBImpl userDaoDB = new UserDaoDBImpl();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        userDaoDB.addUser(email, password);
        MailSender mailSender = new MailSender();
        try {
            mailSender.sendEmail("leksa680@gmail.com", "alex2002", "leksa680@gmail.com");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/contentServlet").forward(request, response);
    }
}

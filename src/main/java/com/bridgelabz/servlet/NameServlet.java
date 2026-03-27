package com.bridgelabz.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/NameServlet")
public class NameServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");

        if (isValidName(name)) {
            out.println("<h3 style='color:green'>Valid Name: " + name + "</h3>");
        } else {
            out.println("<h3 style='color:red'>Invalid Name! Name must start with a capital letter and have minimum 3 characters.</h3>");
            request.getRequestDispatcher("/name.html").include(request, response);
        }
        out.close();
    }

    private boolean isValidName(String name) {
        if (name == null || name.length() < 3) {
            return false;
        }
        return Character.isUpperCase(name.charAt(0));
    }
}
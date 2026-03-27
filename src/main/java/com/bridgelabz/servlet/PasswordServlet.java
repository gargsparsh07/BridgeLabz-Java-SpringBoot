package com.bridgelabz.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/PasswordServlet")
public class PasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String password = request.getParameter("password");
        String validationMessage = validatePassword(password);

        if (validationMessage.equals("valid")) {
            out.println("<h3 style='color:green'>Valid Password!</h3>");
        } else {
            out.println("<h3 style='color:red'>" + validationMessage + "</h3>");
            request.getRequestDispatcher("/password.html").include(request, response);
        }
        out.close();
    }

    private String validatePassword(String password) {
        if (password == null || password.length() < 8) {
            return "Invalid! Rule 1: Password must have minimum 8 characters.";
        }

        boolean hasUpperCase = false;
        boolean hasDigit = false;
        int specialCharCount = 0;
        String specialChars = "!@#$%^&*()_+-=[]{}|;':\",./<>?";

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpperCase = true;
            if (Character.isDigit(c)) hasDigit = true;
            if (specialChars.indexOf(c) >= 0) specialCharCount++;
        }

        if (!hasUpperCase) {
            return "Invalid! Rule 2: Password must have at least 1 uppercase letter.";
        }
        if (!hasDigit) {
            return "Invalid! Rule 3: Password must have at least 1 numeric number.";
        }
        if (specialCharCount != 1) {
            return "Invalid! Rule 4: Password must have exactly 1 special character.";
        }

        return "valid";
    }
}
package com.data.ss2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head><title>Register</title></head>");
            out.println("<body>");
            out.println("<h1>Register Form</h1>");
            out.println("<form method='POST' action='register'>");
            out.println("Name: <input type='text' name='name'><br>");
            out.println("Email: <input type='text' name='email'><br>");
            out.println("<input type='submit' value='Register'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Lấy thông tin từ form
        String name = request.getParameter("name");
        String email = request.getParameter("email");


        response.sendRedirect("thankyou.jsp");
    }
}

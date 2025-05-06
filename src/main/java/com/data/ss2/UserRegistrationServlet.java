package com.data.ss2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/registerUser")
public class UserRegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Lấy dữ liệu từ form
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Gắn dữ liệu vào request
        request.setAttribute("name", name);
        request.setAttribute("email", email);
        request.setAttribute("password", password);

        // Chuyển tiếp sang trang userInfo.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("userInfo.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // để hiển thị form hoặc xử lý logic khác
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head><title>User Registration</title></head>");
            out.println("<body>");
            out.println("<h1>User Registration Form</h1>");
            out.println("<form method='POST' action='registerUser'>");
            out.println("Name: <input type='text' name='name'><br>");
            out.println("Email: <input type='text' name='email'><br>");
            out.println("Password: <input type='password' name='password'><br>");
            out.println("<input type='submit' value='Register'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}

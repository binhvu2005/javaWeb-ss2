package com.data.ss2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/userinfo")
public class UserInfoServlet extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            out.println("<html>");
            out.println("<head><title>User Info</title></head>");
            out.println("<body>");
            out.println("<h1>User Information</h1>");
            out.println("<form method='POST' action='userinfo'>");
            out.println("Name: <input type='text' name='name'><br>");
            out.println("Age: <input type='text' name='age'><br>");
            out.println("<input type='submit' value='Submit'>");
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

        String name = request.getParameter("name");
        String age = request.getParameter("age");

        request.setAttribute("name", name);
        request.setAttribute("age", age);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head><title>User Info</title></head>");
            out.println("<body>");
            out.println("<h1>User Information</h1>");
            out.println("<p>Name: " + name + "</p>");
            out.println("<p>Age: " + age + "</p>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

}

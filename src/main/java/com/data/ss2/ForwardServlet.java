package com.data.ss2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head><title>User Info</title></head>");
            out.println("<body>");
            out.println("<h1>User add </h1>");
            out.println("<form method='POST' action='forward'>");
            out.println("Name: <input type='text' name='name'><br>");
            out.println("add: <input type='text' name='add'><br>");
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
        String add = request.getParameter("add");

        request.setAttribute("name", name);
        request.setAttribute("add", add);

        RequestDispatcher dispatcher = request.getRequestDispatcher("display.jsp");
        dispatcher.forward(request, response);
    }
}

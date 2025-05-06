package com.data.ss2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Định nghĩa URL truy cập Servlet
@WebServlet("/lifecycle")
public class LifecycleServlet extends HttpServlet {

    // Giai đoạn khởi tạo: chỉ chạy một lần duy nhất khi Servlet được tạo ra
    @Override
    public void init() throws ServletException {
        System.out.println("Servlet đang được khởi tạo (init)");
    }

    // Giai đoạn phục vụ yêu cầu: được gọi mỗi khi người dùng gửi request đến Servlet
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head><title>Vòng đời của Servlet</title></head>");
            out.println("<body>");
            out.println("<h1>Vòng đời của Servlet</h1>");
            out.println("<ul>");
            out.println("<li><b>init():</b> Được gọi một lần duy nhất khi servlet được tạo ra.</li>");
            out.println("<li><b>service():</b> Được gọi mỗi khi có request gửi đến servlet. Trong trường hợp này là doGet().</li>");
            out.println("<li><b>destroy():</b> Được gọi khi servlet bị loại bỏ khỏi bộ nhớ.</li>");
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // Giai đoạn hủy: được gọi một lần duy nhất trước khi servlet bị loại bỏ
    @Override
    public void destroy() {
        System.out.println("Servlet đang bị hủy (destroy)");
    }
}

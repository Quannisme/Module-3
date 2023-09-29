package codegym.demoservlet.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "sum", urlPatterns = "/sum")
public class SumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a = Integer.parseInt(req.getParameter("a"));
        int b = Integer.parseInt(req.getParameter("b"));
//        resp.setCharacterEncoding("UTF-8");
//        PrintWriter writer = resp.getWriter();
//        writer.println("<html>");
//        writer.println("<head>");
//        writer.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
//        writer.println("</head>");
//        writer.println("<body>");
//        writer.println("Tổng của a và b là: <b>" + (a+b) + "</b>");
//        writer.println("</body>");
//        writer.println("</html>");
        int sum = a + b;
        req.setAttribute("sum", sum);
        req.getRequestDispatcher("sum.jsp").forward(req, resp);
    }
}

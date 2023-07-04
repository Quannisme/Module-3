package com.example.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogInServlet",urlPatterns = "/Login")
public class LogInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("LogIn.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        PrintWriter writer=resp.getWriter();
        writer.println("<html>");
        if(username.equals("admin") && password.equals("1234"))
        {
            writer.println("<h1>welcome"+ username+"to website</h1>");
        }else
        {
            writer.println("<h1>Login Error</h1>");
        }
        writer.println("</html>");
    }
}

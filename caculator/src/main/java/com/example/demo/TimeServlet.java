package com.example.demo;
import java.io.*;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(name = "TimeServlet", urlPatterns = "/today")
public class TimeServlet extends HttpServlet {
    @Override    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date today=new Date();
        req.setAttribute("Time",today);
        req.getRequestDispatcher("Time.jsp").forward(req,resp);
    }
}

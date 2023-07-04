package com.example.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name ="ProductDiscountServlet" , urlPatterns = "/product")
public class ProductDiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getRequestDispatcher("ProductDiscount.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String decription=req.getParameter("decription");
        double listPrice=Double.parseDouble(req.getParameter("listPrice"));
        double discountPercent=Double.parseDouble(req.getParameter("discountPercent"));
        double result=listPrice*discountPercent*0.01;
        req.setAttribute("result",result);
        req.getRequestDispatcher("ProductDiscount.jsp").forward(req,resp);
    }
}

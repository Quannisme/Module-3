package Cong_Tru_Nhan_Chia.controller;

import Cong_Tru_Nhan_Chia.entity.Caculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/caculator")
public class CaculatorController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("Caculator.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float first = Integer.parseInt(req.getParameter("First"));
        float second = Integer.parseInt(req.getParameter("Second"));
        char operator = req.getParameter("operator").charAt(0);
        float result = Caculator.caculate(first, second, operator);
        req.setAttribute("result", result);
        req.getRequestDispatcher("Caculator.jsp").forward(req, resp);
    }
}

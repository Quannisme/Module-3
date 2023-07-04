package bai_tap.controller;

import bai_tap.entity.Customer;
import bai_tap.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(urlPatterns = "/list")
public class RenderController extends HttpServlet {
    private CustomerService service=new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer>customers=service.getList();
        req.setAttribute("Customer",customers);
        req.getRequestDispatcher("Render.jsp").forward(req,resp);
    }
}

package codegym.demoservlet.controller;

import codegym.demoservlet.entity.Student;
import codegym.demoservlet.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/student/list")
public class StudentController extends HttpServlet {
    private StudentService service = new StudentService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = service.getList();
        req.setAttribute("studentList", students);
        req.getRequestDispatcher("/student/list_jstl.jsp").forward(req, resp);
    }
}

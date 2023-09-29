package com.example.casestudy.code.controller;

import com.example.casestudy.code.model.*;
import com.example.casestudy.code.service.imple.*;
import com.example.casestudy.code.service.inter.*;
import com.example.casestudy.code.validate.EmployeeValidate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet (urlPatterns = "/furama")
public class FuramaController extends HttpServlet {
    private DivisionServiceInter divisionService=new DivisionServiceImpl();
    private EducationDegreeServiceInter educationDegreeService=new EducationDegreeServiceImpl();
    private PositionServiceInter positionService=new PositionServiceImpl();
    private EmployeeServiceInter employeeService=new EmployeeServiceImpl();
    private UserServiceInter userService=new UserServiceImpl();
    private CustomerTypeServiceInter customerTypeService=new CustomerTypeServiceImple();
    private CustomerServiceInter customerService=new CustomerServiceImpl();
    private EmployeeValidate validate=new EmployeeValidate();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if(action==null)
        {
            action="";
        }
        switch (action) {
            case "createUser":
                insertUser(req, resp);
                break;
            case "createEmployee":
                insertEmployee(req, resp);
                break;
            case "editEmployee":
                doeditEmployee(req,resp);
                break;
            case "createCustomer":
                insertCustomer(req,resp);
                break;
            case "search":
                findName(req,resp);
                break;
            case "multi":
                doFindMutil(req,resp);
                break;
            case "id":
                doFindById(req,resp);
                break;
        }
    }

    private void doFindById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("employeeId");
        Employee employee=employeeService.findById(id);
        req.setAttribute("employee", employee);
        req.getRequestDispatcher("wed/infor.jsp")
                .forward(req, resp);
    }


    private void doFindMutil(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type=req.getParameter("type");
        String keyword=req.getParameter("keyword");
        if ("employeeName".equals(type))
        {
            Employee employee=employeeService.findByName(keyword);
            req.setAttribute("employee", employee);
            req.getRequestDispatcher("wed/infor.jsp")
                    .forward(req, resp);
        }else  if("employeeid".equals(type))
        {
            Employee employee=employeeService.findById(keyword);
            req.setAttribute("employee", employee);
            req.getRequestDispatcher("wed/infor.jsp")
                    .forward(req, resp);
        }
    }

    private void findName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("input-change");
        String id  =req.getParameter("input-change");
        String idcard=req.getParameter("input-change");
        List<Employee>employees=employeeService.showBy(id,name,idcard);
        req.setAttribute("employees",employees);
        RequestDispatcher dispatcher = req.getRequestDispatcher("wed/ListEmployee.jsp");
        dispatcher.forward(req, resp);
    }


    private void insertCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        int customerType=Integer.parseInt(req.getParameter("customerType"));
        CustomerType customerType1= customerTypeService.findId(customerType);
        String name=req.getParameter("name");
        String date = req.getParameter("birthday");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date birthday = null;
        try {
            birthday =  format.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String genderr=req.getParameter("gender");
        boolean gender=true;
        if(genderr.equals("female"))
        {
            gender=false;
        }
        String idcard=req.getParameter("idcard");
        String phone=req.getParameter("phone");
        String email=req.getParameter("email");
        String adress=req.getParameter("adress");
        Customer customer=new Customer(id,customerType1,name,birthday,gender,idcard,phone,email,adress);
        customerService.add(customer);
        listCustomer(req,resp);
    }

    private void doeditEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String  id=req.getParameter("id");
        String name=req.getParameter("name");
        String date = req.getParameter("birthday");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date birthday = null;
        try {
            birthday =  format.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String idCard=req.getParameter("idcard");
        double salary=Double.parseDouble(req.getParameter("salary"));
        String phone=req.getParameter("phone");
        String email=req.getParameter("email");
        String adress=req.getParameter("adress");
        int positionId=Integer.parseInt(req.getParameter("PositionID"));
        Position position=positionService.findById(positionId);
        int education=Integer.parseInt(req.getParameter("Education"));
        EducationDegree educationDegree=educationDegreeService.findEducationById(education);
        int division=Integer.parseInt(req.getParameter("division"));
        Division division1=divisionService.findById(division);
        String user=req.getParameter("user");
        User user1=userService.findByName(user);
        Employee employee=new Employee(id,name,birthday,idCard,salary,phone,email,adress,position,educationDegree,division1,user1);
        employeeService.update(employee);
        RequestDispatcher dispatcher = req.getRequestDispatcher("wed/EditEmployee.jsp");
        dispatcher.forward(req, resp);
    }

    private void insertEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        boolean isValidate = true;
        String id=req.getParameter("id");
        String name=req.getParameter("name");
        String date = req.getParameter("birthday");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date birthday = null;
        try {
            birthday =  format.parse(date);
        } catch (ParseException e) {
            isValidate = false;
            throw new RuntimeException(e);
        }
        String idCard=req.getParameter("idcard");
        String errIdCard=null;
        if (!validate.isCmnd(idCard)){
            isValidate=false;
            errIdCard="So cmnd sai roi";
        }
        String cmnd="";
        if (errIdCard != null) {
            req.setAttribute("errIdCard", errIdCard);
        } else {
            idCard= cmnd;
        }
        double salary=Double.parseDouble(req.getParameter("salary"));
        String pphone=req.getParameter("phone");
        String errorPhone = null;
        if (!validate.isPhone(pphone)) {
            isValidate = false;
            errorPhone = "So dien thoai khong hop le";
        }
        String phone="";
        if (errorPhone != null) {
            req.setAttribute("errorPhone", errorPhone);
        } else {
            phone= pphone;
        }
        String email=req.getParameter("email");
        String errEmail=null;
        if (!validate.isEmail(email)){
            isValidate=false;
            errEmail="Email sai roi";
        }
        String emaill="";
        if (errEmail != null) {
            req.setAttribute("errEmail", errEmail);
        } else {
            emaill= emaill;
        }
        String adress=req.getParameter("adress");
        int positionId=Integer.parseInt(req.getParameter("PositionID"));
        Position position=positionService.findById(positionId);
        int education=Integer.parseInt(req.getParameter("Education"));
        EducationDegree educationDegree=educationDegreeService.findEducationById(education);
        int division=Integer.parseInt(req.getParameter("division"));
        Division division1=divisionService.findById(division);
        String user=req.getParameter("user");
        User user1=userService.findByName(user);
        if (isValidate) {
            Employee employee=new Employee(id,name,birthday,idCard,salary,phone,email,adress,position,educationDegree,division1,user1);
            employeeService.add(employee);
            showEmployee(req,resp);}
        else {
            createEmployee(req,resp);
        }
    }

    private void insertUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        User newUser=new User(name,password);
        userService.add(newUser);
        createEmployee(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "createEmployee":
                createEmployee(req, resp);
                break;
            case "createUser":
                createUser(req, resp);
                break;
            case "listEmployee":
                showEmployee(req,resp);
                break;
            case "delete":
                deleteEmployee(req, resp);
                break;
            case "edit":
                editEmployee(req,resp);
                break;
            case "createCustomer"    :
                createCustomer(req,resp);
                break;
            case "listCustomer":
                listCustomer(req,resp);
                break;
            case "editCustomer":
                editCustomer(req,resp);
                break;
            case "deleteCustomer"  :
                deleteCustomer(req,resp);
                break;
//            case "search":
//                dosearch(req,resp);
//                break;
            default:
                page(req, resp);
                break;
        }
    }

    private void deleteCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id =req.getParameter("id");
        customerService.delete(id);

        List<Customer> customers = customerService.findAll();
        req.setAttribute("customer", customers);
        listCustomer(req,resp);
    }

    private void editCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CustomerType>customerTypes=customerTypeService.findAll();
        req.setAttribute("customerType",customerTypes);
        String id = req.getParameter("id");
        Customer existingCustomer=customerService.findId(id);
        req.setAttribute("customer", existingCustomer);
        RequestDispatcher dispatcher = req.getRequestDispatcher("wed/editCustomer.jsp");
        dispatcher.forward(req, resp);
    }

    private void dosearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("employeeName");
        Employee employee=employeeService.findByName(name);
        req.setAttribute("employee", employee);
        req.getRequestDispatcher("wed/infor.jsp")
                .forward(req, resp);
    }

    private void listCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer>customers=customerService.findAll();
        req.setAttribute("customer",customers);
        RequestDispatcher dispatcher = req.getRequestDispatcher("wed/ListCustomer.jsp");
        dispatcher.forward(req, resp);
    }

    private void createCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CustomerType>customerTypes=customerTypeService.findAll();
        req.setAttribute("customertype",customerTypes);
        RequestDispatcher dispatcher = req.getRequestDispatcher("wed/CreateCustomer.jsp");
        dispatcher.forward(req, resp);
    }

    private void editEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Position> positionEdit = positionService.findAll();
        req.setAttribute("positionedit", positionEdit);
        List<EducationDegree>educationDegreesEdit=educationDegreeService.findALL();
        req.setAttribute("educationedit",educationDegreesEdit);
        List<Division>divisionsEdit=divisionService.FindALL();
        req.setAttribute("divisionedit",divisionsEdit);
        List<User>usersEdit=userService.findAll();
        req.setAttribute("useredit",usersEdit);

        String id = req.getParameter("id");
        Employee existingEmployee=employeeService.findById(id);
        req.setAttribute("employee", existingEmployee);
        RequestDispatcher dispatcher = req.getRequestDispatcher("wed/EditEmployee.jsp");
        dispatcher.forward(req, resp);
    }

    private void deleteEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id =req.getParameter("id");
        employeeService.delete(id);

        List<Employee> employees = employeeService.FindAll();
        req.setAttribute("employees", employees);
        RequestDispatcher dispatcher = req.getRequestDispatcher("wed/ListEmployee.jsp");
        dispatcher.forward(req, resp);
    }

    private void showEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee>employees=employeeService.FindAll();
        req.setAttribute("employees",employees);
        RequestDispatcher dispatcher = req.getRequestDispatcher("wed/ListEmployee.jsp");
        dispatcher.forward(req, resp);
    }

    private void createUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("wed/CreateUser.jsp");
        dispatcher.forward(req, resp);
    }

    private void createEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Position> positions = positionService.findAll();
        req.setAttribute("positions", positions);
        List<EducationDegree>educationDegrees=educationDegreeService.findALL();
        req.setAttribute("education",educationDegrees);
        List<Division>divisions=divisionService.FindALL();
        req.setAttribute("division",divisions);
        List<User>users=userService.findAll();
        req.setAttribute("user",users);
        RequestDispatcher dispatcher = req.getRequestDispatcher("wed/CreataEmployee.jsp");
        dispatcher.forward(req, resp);
    }

    private void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("wed/page.jsp");
        dispatcher.forward(req, resp);
    }
}


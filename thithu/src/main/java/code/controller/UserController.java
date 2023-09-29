package code.controller;

import code.modell.Role;
import code.modell.User;
import code.modell.UserRole;
import code.service.imple.UserRoleServiceImpl;
import code.service.inter.UserRoleServiceInter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/user")
public class UserController extends HttpServlet {
    private UserRoleServiceInter userRoleService=new UserRoleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if(action==null)
        {
            action="";
        }
        switch (action) {
            case "createUser":
                page(req, resp);
                break;
            case "delete":
                deleteUser(req,resp);
                break;
            case "edit":
                editUser(req,resp);
                break;
            default:
                listUserRole(req, resp);
                break;
        }
    }

    private void editUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        User userRole =userRoleService.findById(id);
        req.setAttribute("roles", userRoleService.findAllRole());
        req.setAttribute("user", userRole);
        req.getRequestDispatcher("web/edit.jsp").forward(req,resp);
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        userRoleService.remove(id);

        List<UserRole> userRoleList = userRoleService.findAll();
        req.setAttribute("userRoleList", userRoleList);
        req.getRequestDispatcher("web/List.jsp").forward(req, resp);
    }

    private void listUserRole(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserRole> userRoleList = userRoleService.findAll();
        req.setAttribute("userRoleList", userRoleList);
        req.getRequestDispatcher("web/List.jsp").forward(req, resp);
    }

    private void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Role>roles=userRoleService.findAllRole();
        req.setAttribute("role", roles);
        RequestDispatcher dispatcher = req.getRequestDispatcher("web/Create.jsp");
        dispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if(action==null)
        {
            action="";
        }
        switch (action) {
            case "createUser":
                createUser(req, resp);
                break;
            case "edit":
                doeditUser(req,resp);
                break;
            case "search":
                dosearch(req,resp);
                break;
            default:
                insertUser(req, resp);
                break;
        }
    }

    private void dosearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("input-change");
        String name = req.getParameter("input-change");
        String role_name = req.getParameter("input-change");
        String id=req.getParameter("input-change");
        List<UserRole> userRoleList = userRoleService.showBy(name,id,code,role_name);
        req.setAttribute("userRoleList", userRoleList);
        req.getRequestDispatcher("web/List.jsp").forward(req, resp);
    }

    private void doeditUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String idParam = req.getParameter("id");
        String name = req.getParameter("name");
        String code = req.getParameter("code");
        String date = req.getParameter("birthday");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date birthday = null;
        try {
            birthday =  format.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String release = req.getParameter("release");
        SimpleDateFormat formatRelease = new SimpleDateFormat("dd/MM/yyyy");
        Date dateRelease = null;
        try {
            dateRelease =  formatRelease.parse(release);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String[] roleList = req.getParameterValues("role");

        List<Role> roles = new ArrayList<>();
        for (String r : roleList) {
            Role role = new Role();
            role.setId(Integer.parseInt(r));
            roles.add(role);
        }
        User user = new User(idParam, name, code, birthday, dateRelease, roles);
        userRoleService.update(user);
        listUserRole(req,resp);
    }

    private void insertUser(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void createUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        String[] roleList = req.getParameterValues("role");

        List<Role> roles = new ArrayList<>();
        for (String r : roleList) {
            Role role = new Role();
            role.setId(Integer.parseInt(r));
            roles.add(role);
        }
        String name=req.getParameter("name");
        String code=req.getParameter("code");
        String date = req.getParameter("birthday");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date birthday = null;
        try {
            birthday =  format.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String date2 = req.getParameter("dateRelease");
        SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
        Date dateRelease = null;
        try {
            dateRelease =  format2.parse(date2);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        User user=new User(id,name,code,birthday,dateRelease,roles);
        userRoleService.add(user);
        listUserRole(req,resp);
    }
}

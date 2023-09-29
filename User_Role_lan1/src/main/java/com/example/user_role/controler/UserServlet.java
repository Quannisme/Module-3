package com.example.user_role.controler;

import com.example.user_role.model.Role;
import com.example.user_role.model.User;
import com.example.user_role.model.UserRole;
import com.example.user_role.service.UserRoleServiceI;
import com.example.user_role.service.UserRoleServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@WebServlet(name = "USerServlet", value = "/user")
public class UserServlet extends HttpServlet {
    UserRoleServiceI serviceI = new UserRoleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "null";
        }
        switch (action) {
            case "add":
                viewCreate(req, resp);
                break;
            case "list":
                viewList(req, resp);
                break;
            case  "edit":
                try {
                    viewEdit(req,resp);
                } catch (SQLException e) {
                }
                break;
            default:
                break;
        }

    }

    private void viewEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
      int id = Integer.parseInt(req.getParameter("id"));
        UserRole userRole =serviceI.findById(id);
        serviceI.update(userRole);
        req.setAttribute("userRole",userRole);
        req.getRequestDispatcher("/WEB-INF/view/user/list.jsp").forward(req,resp);

    }

    private void viewList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserRole> userRoleList = serviceI.findAll();
        req.setAttribute("userRoleList", userRoleList);
        req.getRequestDispatcher("/WEB-INF/view/user/list.jsp").forward(req, resp);
    }

    private void viewCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/user/addUser.jsp").forward(req, resp);
    }

    private void doCreate(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        int id = parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String code = req.getParameter("code");
        String birth = req.getParameter("birth_user");
        String startDate = LocalDate.now().toString();
        String[] roleList = req.getParameterValues("role");

        List<Role> roles = new ArrayList<>();
        for (String r : roleList) {
            Role role = new Role();
            role.setIdRole(Integer.parseInt(r));
            roles.add(role);
        }
        User user = new User(id, name, code, birth, startDate, roles);
        serviceI.add(user);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = null;
        }
        switch (action) {
            case "add":
                try {
                    doCreate(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "delete":
                try {
                    doDeletes(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
//            case "edit":
//                try {
//                    doEdit(req,resp);
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//                break;
            default:
                break;
        }
    }

//    private void doEdit(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
//        int id =Integer.parseInt(req.getParameter("id"));
//        String name = req.getParameter("name");
//        String code = req.getParameter("code");
//        String birth = req.getParameter("birth_user");
//        String startDate = LocalDate.now().toString();
//        String[] roleList = req.getParameterValues("role");
//
//        List<Role> roles = new ArrayList<>();
//        for (String r : roleList) {
//            Role role = new Role();
//            role.setIdRole(Integer.parseInt(r));
//            roles.add(role);
//        }
//        User user = new User(id, name, code, birth, startDate, roles);
//        serviceI.update(user);
//    }

    private void doDeletes(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        String[] idRemove = req.getParameterValues("idRemove");
        for (String idR : idRemove) {
            serviceI.remove(Integer.parseInt(idR));
        }

        try {
            req.getRequestDispatcher("/WEB-INF/view/user/list.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

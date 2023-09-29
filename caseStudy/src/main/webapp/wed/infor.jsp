<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 21/07/2023
  Time: 11:21 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
    <style>
        #table{
            text-align: center;
            border: 1px black;
        }
    </style>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/furama?action=page">Page</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5" id="table" class="table table-hover">
        <caption><h2>List of Employee</h2></caption>
        <form action="/furama" method="get">
            <span>Find By Name</span>
            <input type="text" name="employeeName" id="employeeName" size="15"/>
            <input type="hidden" name="action" value="search">
            <input type="submit" value="Search">
        </form>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>ID Card</th>
            <th>Salary</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Adress</th>
            <th>Position</th>
            <th>Education</th>
            <th>Division</th>
            <th>User Name</th>
            <th>Password</th>
        </tr>
<%--        <c:forEach items="${employee}" var="p">--%>
            <tr>
                <td><c:out value="${employee.id}"/></td>
                <td><c:out value="${employee.name}"/></td>
                    <%--        <td><c:out value="${employee.birthDay}"/></td>--%>
                <td>
                    <fmt:formatDate value="${employee.birthDay}" pattern="dd/MM/yyyy" />
                </td>
                <td><c:out value="${employee.idCard}"/></td>
                <td><c:out value="${employee.salary}"/></td>
                <td><c:out value="${employee.phone}"/></td>
                <td><c:out value="${employee.email}"/></td>
                <td><c:out value="${employee.address}"/></td>
                <td><c:out value="${employee.position.name}"/></td>
                <td><c:out value="${employee.educationDegree.name}"/></td>
                <td><c:out value="${employee.division.name}"/></td>
                <td><c:out value="${employee.user.name}"/></td>
                <td><c:out value="${employee.user.password}"/></td>
                <td>
                        <%--          <a href="/furama?action=edit&id=${employee.id}">Edit</a>--%>
                    <a href="/furama?action=edit&id=${employee.id}" >Edit</a>
                    <a onclick="deletebyid(${p.id})"class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">Delete</a>
                </td>
            </tr>
<%--        </c:forEach>--%>
    </table>
    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Do you want Delete
                </div>
                <div class="modal-footer">
                    <a id="delete" href="">YES</a>
                    <a href="/employeeServlet">NO</a>
                </div>
            </div>
        </div>
    </div>
    <input type="hidden" name="action" value="listInfor">
</div>
<script>
    function  deletebyid(id){
        let a = document.getElementById("delete");
        a.href = "/furama?action=delete&id="+ id;
    }

</script>
<%--<form action="/furama" method="post">--%>
<%--    <p> ID: ${employee.id}</p>--%>
<%--    <p>Name: ${employee.name}</p>--%>
<%--    <p>Email: ${employee.idCard}</p>--%>
<%--    <p> Country: ${employee.address}</p>--%>
<%--</form>--%>

</body>
</body>
</html>

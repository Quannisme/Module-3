<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 20/07/2023
  Time: 12:13 SA
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
</head>
<body>
<center>
  <h1>User</h1>
  <h2>
    <a href="/user?action=createUser">Create</a>
  </h2>
  <form class="form-inline my-2 my-lg-0" method="post" action="/user?action=search">
    <input class="form-control mr-sm-2" type="search" placeholder="Search"name="input-change">
    <input type="hidden" name="action" value="search">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
  </form>
</center>
<div align="center">
  <table border="1" cellpadding="5">
    <caption><h2>List of user</h2></caption>
    <tr>
      <th>ID</th>
      <th>Role</th>
      <th>Name</th>
      <th>Code</th>
      <th>Birtday</th>
      <th>date Release</th>
    </tr>
    <c:forEach var="userRoleList" items="${userRoleList}">
      <tr>
        <td><c:out value="${userRoleList.getUser().getId()}"/></td>
        <td><c:out value="${userRoleList.getRole().getName()}"/></td>
        <td><c:out value="${userRoleList.getUser().getName()}"/></td>
        <td><c:out value="${userRoleList.getUser().getCode()}"/></td>
        <td>
          <fmt:formatDate value="${userRoleList.user.birthday}" pattern="dd/MM/yyyy" />
        </td>
        <td>
          <fmt:formatDate value="${userRoleList.getUser().getDateRelease()}" pattern="dd/MM/yyyy" />
        </td>
        <td>
          <a href="/user?action=edit&id=${userRoleList.getUser().getId()}">Edit</a>
          <a href="/user?action=delete&id=${userRoleList.getUser().getId()}">Delete</a>
        </td>
      </tr>
    </c:forEach>
  </table>
  <input type="hidden" name="action" value="listUserRole">
</div>
</body>
</html>

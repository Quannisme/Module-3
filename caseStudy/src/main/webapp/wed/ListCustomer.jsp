<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 19/07/2023
  Time: 10:16 SA
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
  <h1>Customer Managerment</h1>
  <h2>
    <a href="/furama?action=page">Page</a>
  </h2>
</center>
<div align="center">
  <table border="1" cellpadding="5">
    <caption><h2>List of Employee</h2></caption>
    <tr>
      <th>#</th>
      <th>ID</th>
      <th>Customer Type</th>
      <th>Name</th>
      <th>Birth Day</th>
      <th>Gender</th>
      <th>Id card</th>
      <th>Phone</th>
      <th>Email</th>
      <th>Adress</th>
    </tr>
    <c:forEach var="customer" items="${customer}" varStatus="item">
      <tr>
        <td><c:out value="${item.count}"/></td>
        <td><c:out value="${customer.id}"/></td>
        <td><c:out value="${customer.customerType.id}"/></td>
        <td><c:out value="${customer.name}"/></td>
          <%--        <td><c:out value="${employee.birthDay}"/></td>--%>
        <td>
          <fmt:formatDate value="${customer.birthDay}" pattern="dd/MM/yyyy" />
        </td>
        <td>
          <c:if test="${customer.gender == true}">
            Male
          </c:if>
          <c:if test="${customer.gender == false}">Female</c:if>
        </td>
        <td><c:out value="${customer.idCard}"/></td>
        <td><c:out value="${customer.phone}"/></td>
        <td><c:out value="${customer.email}"/></td>
        <td>
          <a href="/furama?action=editCustomer&id=${customer.id}">Edit</a>
          <a href="/furama?action=deleteCustomer&id=${customer.id}">Delete</a>
        </td>
      </tr>
    </c:forEach>
  </table>
  <input type="hidden" name="action" value="listEmployee">
</div>
</body>
</html>

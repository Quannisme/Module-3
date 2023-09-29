<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 24/07/2023
  Time: 8:38 CH
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
<div align="center">
  <form method="post">
    <table border="1" cellpadding="5">
      <caption>
        <h2>Edit Customer</h2>
      </caption>
      <c:if test="${customer != null}">
        <input type="hidden" name="id" value="<c:out value='${customer.id}' />"/>
      </c:if>
      <tr>
        <th>ID:</th>
        <td>
          <input type="text" name="id" id="id" size="45"
                 value="<c:out value='${customer.id}' />"/>
        </td>
      </tr>
      <tr>
        <th>Customer Type:</th>
        <td>
          <select name="customerType">
            <c:forEach items="${customerType}" var="c">
              <c:if test="${customer.customerType.name.equals(c.name)}">
                <option value="${c.id}" selected>${c.name}</option>
              </c:if>
              <option value="${c.id}">${c.name}</option>
            </c:forEach>
          </select>
        </td>
      </tr>
      <tr>
        <th>name:</th>
        <td>
          <input type="text" name="name" id="name" size="45"
                 value="<c:out value='${customer.name}' />"/>
        </td>
      </tr>
      <tr>
        <th>BirthDay:</th>
        <td>
          <input type="text" name="birthday" id="birthday" size="45"/>
        </td>
      </tr>
      <tr>
        <th>Gender:</th>
        <td>
          <c:if test="${customer.gender==true}">
            <input type="radio" id="gender" name="gender" value="male" checked> Nam
            <input type="radio" name="gender" value="female" > Nu
          </c:if>
          <c:if test="${customer.gender==false}">
            <input type="radio" id="gender" name="gender" value="male" > Nam
            <input type="radio" name="gender" value="female" checked > Nu
          </c:if>
        </td>
      </tr>
      <tr>
        <th>Id Card:</th>
        <td>
          <input type="text" name="idcard" id="idcard" size="45"/>
        </td>
      </tr>
      <tr>
        <th>phone:</th>
        <td>
          <input type="text" name="phone" id="phone" size="45"/>
        </td>
      </tr>
      <tr>
        <th>email:</th>
        <td>
          <input type="text" name="email" id="email" size="45"/>
        </td>
      </tr>
      <tr>
        <th>adress:</th>
        <td>
          <input type="text" name="adress" id="adress" size="45"/>
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="Save"/>
        </td>
      </tr>
    </table>
    <input type="hidden" name="action" value="createCustomer">
  </form>
</div>
</body>
</html>

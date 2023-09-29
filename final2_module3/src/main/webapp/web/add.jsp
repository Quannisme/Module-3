<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 28/07/2023
  Time: 7:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create Benh An </h1>
<h2>
    <a href="benhvien?action=list">List benh</a>
</h2>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New benh an</h2>
            </caption>
            <tr>
                <th>Ma Benh An :</th>
                <td>
                    <select name="benhan">
                        <c:forEach items="${benhan}" var="b">
                            <option value="${b.id}">${b.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Ma Benh Nhan:</th>
                <td>
                    <input type="text" name="id" id="id" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
        <input type="hidden" name="action" value="createUser">
    </form>
</div>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 26/07/2023
  Time: 6:32 CH
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
    <h1>Danh Sach Benh An</h1>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Danh Sach of Benh an</h2></caption>
        <tr>
            <th>STT</th>
            <th>Ma Benh AN</th>
            <th>Ma Benh Nhan</th>
            <th>Ten Benh Nhan</th>
            <th>Ngay Nhap Vien</th>
            <th>Ngay Ra Vien</th>
            <th>Ly Do Nhap Vien</th>
        </tr>
        <c:forEach var="b" items="${benh}" varStatus="item">
            <tr>
                <td><c:out value="${item.count}"/></td>
                <td><c:out value="${b.benhAn.id}"/></td>
                <td><c:out value="${b.id}"/></td>
                <td><c:out value="${b.name}"/></td>
                    <%--        <td><c:out value="${employee.birthDay}"/></td>--%>
                <td>
                    <fmt:formatDate value="${b.in}" pattern="dd/MM/yyyy" />
                </td>
                <td>
                    <fmt:formatDate value="${b.out}" pattern="dd/MM/yyyy" />
                </td>
                <td><c:out value="${b.lyDo}"/></td>
                <td>
                    <a href="/benh?action=doedit&id=${b.id}">Edit</a>
                    <a href="/benh?action=delete&id=${b.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="hidden" name="action" value="list">
</div>
</body>
</html>
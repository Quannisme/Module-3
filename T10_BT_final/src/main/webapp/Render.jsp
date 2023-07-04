<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 04/07/2023
  Time: 11:50 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh Sach Khach Hang</h1><br>
<table>
    <tr>
        <th>Ten</th>
        <th>Ngay sinh </th>
        <th>Dia chi </th>
        <th>Anh</th>
    </tr>
    <c:forEach items="${Customer}" var="c">
        <tr>
            <td>${c.name}</td>
            <td>${c.data}</td>
            <td>${c.adress}</td>
            <td><img src="${c.image}" width="80px" height="80px"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

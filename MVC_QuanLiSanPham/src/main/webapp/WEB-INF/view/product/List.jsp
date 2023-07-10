<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 05/07/2023
  Time: 7:27 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>List Product</h1>
    <a href="/product?action=create">Add new Product</a>
    <a href="/product?action=delete">Delete Product</a>
    <a href="/product?action=findName">Find Name Product</a>
    <a href="/product?action=update">Update Product</a>
    <table>
        <tr>
            <th>id</th>
            <th>Product Name</th>
            <th>Product Price</th>
            <th>Decription</th>
            <th>Producer</th>
        </tr>
        <c:forEach items="${products}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.price}</td>
                <td>${p.describe}</td>
                <td>${p.producer}</td>
<%--                <td>--%>
<%--                    <form action="/product" method="post">--%>
<%--                        <input type="hidden" name="name" value="${p.name}">--%>
<%--                        <button name="action" value="delete2">Delete</button>--%>
<%--                    </form>--%>
<%--                </td>--%>
                <td>
                    <a href="/product?action=delete2&name=${p.name}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

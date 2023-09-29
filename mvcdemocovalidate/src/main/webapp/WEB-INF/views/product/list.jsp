<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List product</title>
</head>
<body>
    <h1>List product</h1>
    <a href="/product?action=create">Add new product</a>
    <form action="/product" method="get">
        <label>Product name</label>
        <input type="text" name="productName">
        <input type="hidden" name="action" value="search">
        <br>
        <input type="submit" value="Search">
    </form>
    <form action="/product" method="post">
        <table>
            <tr>
                <th></th>
                <th>STT</th>
                <th>ID</th>
                <th>Name</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Date release</th>
                <th>Category</th>
            </tr>
            <c:forEach items="${products}" var="p" varStatus="index">
                <tr>
                    <td><input type="checkbox" name="ids" value="${p.id}"></td>
                    <td>${index.count}</td>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.quantity}</td>
                    <td>${p.price}</td>
                    <td>
                        <fmt:formatDate value="${p.dateRelease}" pattern="dd/MM/yyyy" />
                    </td>
                    <td>${p.category.name}</td>
                </tr>
            </c:forEach>
        </table>
        <c:forEach items="${pages}" var="p">
            <c:choose>
                <c:when test="${p == currentPage}">${p}</c:when>
                <c:otherwise>
                    <a href="/product?action=list&page=${p}">${p}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <input type="submit" value="Delete All">
        <input type="hidden" name="action" value="deleteAll">
    </form>
</body>
</html>

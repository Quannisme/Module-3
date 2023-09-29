<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new product</title>
</head>
<body>
<h1>Create new product</h1>
<form action="/product" method="post">
    <h3>Product 1</h3>
    <table>
        <tr>
            <td>ID</td>
            <td><input type="text" name="id1"/></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name1"/></td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td><input type="text" name="quantity1"/></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price1"/></td>
        </tr>
        <tr>
            <td>Date release</td>
            <td><input type="text" placeholder="dd/MM/yyyy" name="dateRelease1"/></td>
        </tr>
        <tr>
            <td>Category</td>
            <td>
                <select name="categoryId1">
                    <c:forEach items="${categories}" var="c">
                        <option value="${c.id}">${c.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>

    <h3>Product 2</h3>
    <table>
        <tr>
            <td>ID</td>
            <td><input type="text" name="id2"/></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name2"/></td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td><input type="text" name="quantity2"/></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price2"/></td>
        </tr>
        <tr>
            <td>Date release</td>
            <td><input type="text" placeholder="dd/MM/yyyy" name="dateRelease2"/></td>
        </tr>
        <tr>
            <td>Category</td>
            <td>
                <select name="categoryId2">
                    <c:forEach items="${categories}" var="c">
                        <option value="${c.id}">${c.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>

    <h3>Product 3</h3>
    <table>
        <tr>
            <td>ID</td>
            <td><input type="text" name="id3"/></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name3"/></td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td><input type="text" name="quantity3"/></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price3"/></td>
        </tr>
        <tr>
            <td>Date release</td>
            <td><input type="text" placeholder="dd/MM/yyyy" name="dateRelease3"/></td>
        </tr>
        <tr>
            <td>Category</td>
            <td>
                <select name="categoryId3">
                    <c:forEach items="${categories}" var="c">
                        <option value="${c.id}">${c.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>
    <br>
    <input type="submit" value="Add all">
    <input type="hidden" name="action" value="createMulti">
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 07/07/2023
  Time: 1:03 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Find Name Product</h1>
<form action="/product" method="post">
    <table>
        <tr>
            <td>Name:</td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="find">
            </td>
        </tr>
    </table>
    <input type="hidden"name="action"value="findName">
</form>
</body>
</html>

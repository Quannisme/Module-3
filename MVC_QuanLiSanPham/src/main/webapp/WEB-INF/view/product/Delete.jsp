<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 05/07/2023
  Time: 8:43 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Delete product</h1>
    <form action="/product" method="post">
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>
                    <input type="submit"value="delete">
                </td>
            </tr>
        </table>
        <input type="hidden"name="action"value="delete">
    </form>
</body>
</html>

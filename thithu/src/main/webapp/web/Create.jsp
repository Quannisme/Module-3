<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 20/07/2023
  Time: 12:07 SA
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
<h1>Create user</h1>
<h2>
    <a href="user?action=listUser">List user</a>
</h2>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New user</h2>
            </caption>
            <tr>
                <th>ID:</th>
                <td>
                    <input type="text" name="id" id="id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Role:</th>
                <td>
                        <input type="checkbox"value="1"name="role">admin
                        <input type="checkbox"value="2"name="role">user
                </td>
            </tr>
            <tr>
                <th>name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Code:</th>
                <td>
                    <input type="text" name="code" id="code" size="45"/>
                </td>
            </tr>
            <tr>
                <th>BirthDay:</th>
                <td>
                    <input type="text" name="birthday" id="birthday" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Date Release:</th>
                <td>
                    <input type="text" name="dateRelease" id="dateRelease" size="45"/>
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

<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 16/07/2023
  Time: 1:26 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
</head>
<body>
<h1>Create Employee</h1>
<h2>
    <a href="furama?action=listEmployee">List Employee</a>
</h2>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5" class="table table-hover">
            <caption>
                <h2>Add New Employee</h2>
            </caption>
            <tr>
                    <th>
                        <label for="id">ID:</label>
                    </th>
                <td>
                    <input type="text" name="id" id="id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>
                    <label for="name">Name:</label>
                </th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>
                    <label for="birthday">BirthDay:</label>
                </th>
                <td>
                    <input type="text" name="birthday" id="birthday" size="45"/>
                </td>
            </tr>
            <tr>
                <th>
                    <label for="idcard">ID Card:</label>
                </th>
                <td>
                    <input type="text" name="idcard" id="idcard" size="45"/>
                </td>
                <td class="error">
                    <c:if test="${errIdCard !=null}">
                        ${errIdCard}
                        <%--                        <c:out value="${errorPhone}"></c:out>--%>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th>
                    <label for="salary">Salary:</label>
                </th>
                <td>
                    <input type="text" name="salary" id="salary" size="45"/>
                </td>
            </tr>
            <tr>
                <th>

                    <label for="phone">Phone:</label>
                </th>
                <td>
                    <input type="text" name="phone" id="phone" size="45"/>
                </td>
                <td class="error">
                    <c:if test="${errorPhone !=null}">
                        ${errorPhone}
<%--                        <c:out value="${errorPhone}"></c:out>--%>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th>email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45"/>
                </td>
                <td class="error">
                    <c:if test="${errEmail !=null}">
                        ${errEmail}
                        <%--                        <c:out value="${errorPhone}"></c:out>--%>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th>adress:</th>
                <td>
                    <input type="text" name="adress" id="adress" size="45"/>
                </td>
            </tr>
            <tr>
                <td>Position</td>
                <td>
                    <select name="PositionID">
                        <c:forEach items="${positions}" var="p">
                            <option value="${p.id}">${p.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Education Degree</td>
                <td>
                    <select name="Education">
                        <c:forEach items="${education}" var="e">
                            <option value="${e.id}">${e.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Division</td>
                <td>
                    <select name="division">
                        <c:forEach items="${division}" var="d">
                            <option value="${d.id}">${d.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>User</td>
                <td>
                    <select name="user">
                        <c:forEach items="${user}" var="u">
                            <option value="${u.name}">${u.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
        <input type="hidden" name="action" value="createEmployee">
    </form>
</div>
</body>
</html>

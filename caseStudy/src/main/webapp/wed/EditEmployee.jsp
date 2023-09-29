<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 17/07/2023
  Time: 7:23 CH
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
    <h1>Edit Employee</h1>
    <h2>
        <a href="furama?action=listEmployee">List Employee</a>
    </h2>
    <div align="center">
        <form method="post" action="/furama">
            <table border="1" cellpadding="5">
                <caption>
                    <h2>Edit Employee</h2>
                </caption>
                <c:if test="${employee != null}">
                    <input type="hidden" name="id" value="<c:out value='${employee.id}' />"/>
                </c:if>
                <tr>
                    <th>Name:</th>
                    <td>
                        <input type="text" name="name" id="name" size="45"
                               value="<c:out value='${employee.name}' />"/>
                    </td>
                </tr>
                <tr>
                    <th>Birthday:</th>
                    <td>
                        <input type="text" name="birthday" id="birthday" size="45"
                               value="<fmt:formatDate value='${employee.birthDay}' pattern='dd/MM/yyyy'/>"
                        />
                    </td>
                </tr>
                <tr>
                    <th>id Card:</th>
                    <td>
                        <input type="text" name="idcard" id="idcard" size="45"
                               value="<c:out value='${employee.idCard}' />"/>
                    </td>
                </tr>
                <tr>
                    <th>Salary:</th>
                    <td>
                        <input type="text" name="salary" id="salary" size="45"
                               value="<c:out value='${employee.salary}' />"/>
                    </td>
                </tr>
                <tr>
                    <th>Phone:</th>
                    <td>
                        <input type="text" name="phone" id="phone" size="45"
                               value="<c:out value='${employee.phone}' />" />
                    </td>
                </tr>
                <tr>
                    <th>email:</th>
                    <td>
                        <input type="text" name="email" id="email" size="45"
                               value="<c:out value='${employee.email}' />" />
                    </td>
                </tr>
                <tr>
                    <th>adress:</th>
                    <td>
                        <input type="text" name="adress" id="adress" size="45"
                               value="<c:out value='${employee.address}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td>Position</td>
                    <td>
                        <select name="PositionID">
                            <c:forEach items="${positionedit}" var="p">
                                <option value="${p.id}">${p.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Education Degree</td>
                    <td>
                        <select name="Education">
                            <c:forEach items="${educationedit}" var="e">
                                <c:if test="${employee.educationDegree.name.equals(e.name)}">
                                    <option value="${e.id}" selected>${e.name}</option>
                                </c:if>
                                <option value="${e.id}">${e.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Division</td>
                    <td>
                        <select name="division">
                            <c:forEach items="${divisionedit}" var="d">
                                <c:if test="${employee.division.name.equals(d.name)}">
                                    <option value="${d.id}" selected>${d.name}</option>
                                </c:if>
                                <option value="${d.id}">${d.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>User</td>
                    <td>
                        <select name="user">
                            <c:forEach items="${useredit}" var="u">
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
            <input type="hidden" name="action" value="editEmployee">
        </form>
    </div>
  </body>
</html>

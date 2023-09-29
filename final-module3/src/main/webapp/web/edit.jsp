<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 28/07/2023
  Time: 8:00 CH
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
<h1>Edit Benh An </h1>
<div align="center">
    <form method="post" action="/benh">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Edit Benh An </h2>
            </caption>
            <c:if test="${benhnhan != null}">
                <input type="hidden" name="id" value="<c:out value='${benhnhan.id}' />"/>
            </c:if>
            <tr>
                <th>Ma Benh An :</th>
                <td>
                    <input type="text" name="benhan" id="benhan" size="45"
                           value="<c:out value='${benhnhan.benhAn.id}' />"/>
                </td>
            </tr>
            <tr>
                <th>Ma Benh Nhan :</th>
                <td>
                    <input type="text" name="id" id="id" size="45"
                           value="<c:out value='${benhnhan.id}' />"/>
                </td>
            </tr>
            <tr>
                <th>Ten Benh Nhan :</th>
                <td>
                    <input type="text" name="name" id="name" size="45"
                           value="<c:out value='${benhnhan.name}' />"/>
                </td>
            </tr>
            <tr>
                <th>Ngay Nhap Vien:</th>
                <td>
                    <input type="text" name="in" id="in" size="45"
                           value="<fmt:formatDate value='${benhnhan.in}' pattern='dd/MM/yyyy'/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Ngay ra Vien:</th>
                <td>
                    <input type="text" name="out" id="out" size="45"
                           value="<fmt:formatDate value='${benhnhan.out}' pattern='dd/MM/yyyy'/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Ly Do:</th>
                <td>
                    <input type="text" name="lydo" id="lydo" size="45"
                           value="<c:out value='${benhnhan.lyDo}' />"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                    <a href="benh?action=list">Tro VE Danh Sach</a>
                </td>
            </tr>
        </table>
        <input type="hidden" name="action" value="edit">
    </form>
</div>
</body>
</html>
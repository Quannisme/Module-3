<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 21/07/2023
  Time: 12:18 SA
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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>
<body>
<form action="/user" method="post">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputName">Full Name</label>
            <input type="text" class="form-control" id="inputName" value="${user.name}"
                   placeholder="Full Name" name="name">
        </div>
        <div class="form-group col-md-6">
            <label for="inputCode">Code</label>
            <input type="text" class="form-control" id="inputCode" value="${user.code}"
                   placeholder="U-XXXX" name="code">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="birthday">BirthDay</label>
            <input type="text" name="birthday" id="birthday" size="45"
                   value="<fmt:formatDate value='${user.birthday}' pattern='dd/MM/yyyy'/>"
            />
        </div>
        <div class="form-group col-md-6">
            <label for="release">Star Day</label>
        <input type="text" name="release" id="release" size="45"
               value="<fmt:formatDate value='${user.dateRelease}' pattern='dd/MM/yyyy'/>"
        />
        </div>

        <div class="form-group col-md-2">
            <c:forEach items="${roles}" var="r">
                <c:set var="flag" value="true"></c:set>
                <c:forEach items="${user.role}" var="role">
                    <c:if test="${r.id == role.id}">
                        <input type="checkbox" class="form-control" value="${r.id}" name="role" checked>
                        <c:set var="flag" value="false"></c:set>
                    </c:if>
                </c:forEach>
                <c:if test="${flag}">
                    <input type="checkbox" class="form-control" value="${r.id}" name="role">
                </c:if>
                <label>${r.name}</label>
            </c:forEach>
        </div>
        <input type="hidden" name="action" value="edit">
        <input type="hidden" name="id" value="${user.id}">
        <input type="hidden" name="id" value="${user.dateRelease}">
        <button type="submit" class="btn btn-primary">Update</button>
    </div>
</form>
</body>
</html>

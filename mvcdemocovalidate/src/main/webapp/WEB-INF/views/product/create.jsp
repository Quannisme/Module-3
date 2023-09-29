<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new product</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <h1>Create new product</h1>
    <form action="/product" method="post">
        <table>
            <tr>
                <td>ID</td>
                <td><input type="text" name="id"/></td>
                <td class="error">
                    <c:if test="${errorId != null}">
                        ${errorId}
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>Quantity</td>
                <td><input type="number" name="quantity"/></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="text" name="price"/></td>
            </tr>
            <tr>
                <td>Date release</td>
                <td><input type="text" placeholder="dd/MM/yyyy" name="dateRelease"/></td>
                <td class="error">
                    <c:if test="${errorDateRelease != null}">
                        ${errorDateRelease}
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>Category</td>
                <td>
                    <select name="categoryId">
                        <c:forEach items="${categories}" var="c">
                            <option value="${c.id}">${c.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Add">
                </td>
            </tr>
        </table>
        <input type="hidden" name="action" value="create">
    </form>
</body>
</html>

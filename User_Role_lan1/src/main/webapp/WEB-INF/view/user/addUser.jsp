
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
<form action="/user?action=add"method="post">
    <input type="checkbox"value="1"name="role">admin
    <input type="checkbox"value="2"name="role">user
    <input type="number"name="id">
    <input type="text"name="name">
    <input type="text"name="code">
    <input type="date"name="birth_user">
    <input type="submit"value="create">
    <input type="hidden"name="action"value="edit">
</form>
</body>
</html>

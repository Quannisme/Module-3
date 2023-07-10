<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 07/07/2023
  Time: 1:11 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/product" method="post">
        <p> ID: ${product.id}</p>
        <p>Name: ${product.name}</p>
        <p>Price: ${product.price}</p>
        <p> Describe: ${product.describe}</p>
        <p>Producer: ${product.producer}</p>
</form>
</body>
</html>

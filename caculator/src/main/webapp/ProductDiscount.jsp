<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 30/06/2023
  Time: 7:22 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/product" method="post">
    <div>
        <h2>Product Discount</h2>
        <input type="text" name="decription" placeholder="Product decription">
        <input type="text" name="listPrice" placeholder="List Price">
        <input type="text" name="discountPercent" placeholder="Discount Percent">
        <input type="submit" value="Submit">
    </div>
    <p>Result: <b> ${result}</b></p>
</form>
</body>
</html>

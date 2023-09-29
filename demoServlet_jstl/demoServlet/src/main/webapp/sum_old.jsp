<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sum jsp</title>
</head>
<body>
    <% int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));%>
    Tổng của 2 số a và b là: <b><%=(a+b)%></b>
</body>
</html>

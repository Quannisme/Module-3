<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 05/07/2023
  Time: 12:30 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>Simple Caculator</h1>
  <form action="/caculator" method="post">
<%--    mac dinh la get nen phai day phuong thuc qua post--%>
    <fieldset>
      <legend>Caculator</legend>
      First operand: <input type="text" name="First"><br>
      Operator: <select name="operator">
      <option value="+">Addition</option>
      <option value="-">Subtraction</option>
      <option value="*">Multiplication</option>
      <option value="/">Division</option>
    </select>
      Second operand: <input type="text" name="Second"><br>
      <input type="submit" value="Submit"><br>
      <p>
        Result: <b>${result}</b>
      </p>
    </fieldset>
  </form>
</body>
</html>

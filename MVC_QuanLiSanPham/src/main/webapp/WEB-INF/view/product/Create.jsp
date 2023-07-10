<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 05/07/2023
  Time: 8:35 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>Add Product</h1>
  <form action="/product" method="post">
    <table>
      <tr>
        <td>ID:</td>
        <td><input type="text" name="id"></td>
      </tr>
      <tr>
        <td>Name:</td>
        <td><input type="text" name="name"></td>
      </tr>
      <tr>
        <td>Price:</td>
        <td><input type="text"name="price"></td>
      </tr>
      <tr>
        <td>describe:</td>
        <td><input type="text"name="describe"></td>
      </tr>
      <tr>
        <td>Producer</td>
        <td><input type="text" name="producer"></td>
      </tr>
      <tr>
        <td>
          <input type="submit"value="add">
        </td>
      </tr>
    </table>
    <input type="hidden" name="action" value="create">
  </form>
</body>
</html>

<%@ page import="java.util.List" %>
<%@ page import="codegym.demoservlet.entity.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student list</title>
</head>
<body>
    <h1>Student list</h1>
    <% List<Student> students = (List<Student>) request.getAttribute("studentList"); %>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Address</th>
            <th>LastYear</th>
        </tr>
        <% for (Student s: students) { %>
            <tr>
                <td><%=s.getId()%></td>
                <td><%=s.getName()%></td>
                <td><%=s.getAge()%></td>
                <td><%=s.getAddress()%></td>
                <td>
                    <%
                        if (s.getAge() >= 22) {
                            %>Năm cuối<%
                        } else {
                            %>Không phải năm cuối<%
                        }
                    %>
                </td>
            </tr> <%
        }
        %>
    </table>
</body>
</html>

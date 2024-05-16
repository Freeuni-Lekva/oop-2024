<%@ page import="java.util.List" %>
<%@ page import="studentsTable.Student" %>
<%@ page import="studentsTable.Db" %><%--
  Created by IntelliJ IDEA.
  User: tamta
  Date: 13.05.24
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Students Page</title>
</head>
<body>
    <div class="container">
        <form action="students" method="post">
            <input type="input" placeholder="First Name" name="first-name">
            <input type="input" placeholder="Last Name" name="last-name">
            <input type="number" placeholder="Year" name="year">
            <input type="submit" name="year">
        </form>

        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Year</th>
            </tr>
            <% List<Student> students = ((Db)application.getAttribute("my-db")).getAll();
    for (Student student: students) {%>
            <tr>
                <td><%= student.getFirstName() %></td>
                <td><%= student.getLastName() %></td>
                <td><%= student.getEnrollmentYear() %></td>
            </tr>
   <% } %>

        </table>
    </div>
</body>
</html>

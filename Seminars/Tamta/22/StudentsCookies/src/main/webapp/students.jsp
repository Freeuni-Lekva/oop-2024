<%@ page import="java.util.List" %>
<%@ page import="studentsTable.Student" %>
<%@ page import="studentsTable.Db" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %><%--
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
        <c:choose>
            <c:when test="${whoami != null}">
                Hello, ${whoami}
            </c:when>

            <c:otherwise>
                <form action="students" method="post">
                    <input type="input" placeholder="First Name" name="first-name">
                    <input type="input" placeholder="Last Name" name="last-name">
                    <input type="number" placeholder="Year" name="year">
                    <input type="submit" name="year">
                </form>
            </c:otherwise>

        </c:choose>

        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Year</th>
            </tr>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td><c:out value="${student.getFirstName()}"/></td>
                    <td><c:out value="${student.getLastName()}"/></td>
                    <td><c:out value="${student.getEnrollmentYear()}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>

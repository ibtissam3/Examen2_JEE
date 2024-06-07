<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>List of Students</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>List of Students</h2>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">NAME</th>
            <th scope="col">Entering Date</th>
            <th scope="col">Nationality</th>
            <th scope="col">CODE</th>
            <th scope="col">ACTIONS</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.name}</td>
                <td>${student.enteringDate}</td>
                <td>${student.nationality}</td>
                <td>${student.code}</td>
                <td>
                    <form action="<c:url value='/edit?studentId=' />" method="get" style="display: inline;">
                        <input type="hidden" name="studentId" value="${student.id}" />
                        <button type="submit" class="btn btn-primary">Edit</button>
                    </form>
                    <form action="<c:url value='/delete' />" method="get" style="display: inline;">
                        <input type="hidden" name="studentId" value="${student.id}" />
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="<c:url value='/new' />" class="btn btn-success">Add New Student</a>
</div>
</body>
</html>

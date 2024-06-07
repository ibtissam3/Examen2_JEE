<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edit Student</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Edit Student</h2>
    <form action="<c:url value='/edit?studentId=${student.id}' />" method="post">
        <input type="hidden" name="studentId" value="${student.id}" />
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" value="${student.name}" />
        </div>
        <div class="form-group">
            <label for="enteringDate">Entering Date:</label>
            <input type="text" class="form-control" id="enteringDate" name="enteringDate" value="${student.enteringDate}" />
        </div>
        <div class="form-group">
            <label for="nationality">Nationality:</label>
            <input type="text" class="form-control" id="nationality" name="nationality" value="${student.nationality}" />
        </div>
        <div class="form-group">
            <label for="code">Code:</label>
            <input type="text" class="form-control" id="code" name="code" value="${student.code}" />
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>
</body>
</html>

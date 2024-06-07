<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Registration Form</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <h2>Registration Form</h2>
    <form:form method="POST" modelAttribute="student">
        <form:input type="hidden" path="id" id="id"/>
        <div class="form-group row">
            <label for="name" class="col-sm-2 col-form-label">Name:</label>
            <div class="col-sm-10">
                <form:input path="name" id="name" class="form-control"/>
                <form:errors path="name" cssClass="error"/>
            </div>
        </div>

        <div class="form-group row">
            <label for="enteringDate" class="col-sm-2 col-form-label">Entering Date:</label>
            <div class="col-sm-10">
                <form:input path="enteringDate" id="enteringDate" class="form-control"/>
                <form:errors path="enteringDate" cssClass="error"/>
            </div>
        </div>

        <div class="form-group row">
            <label for="nationality" class="col-sm-2 col-form-label">Nationality:</label>
            <div class="col-sm-10">
                <form:input path="nationality" id="nationality" class="form-control"/>
                <form:errors path="nationality" cssClass="error"/>
            </div>
        </div>

        <div class="form-group row">
            <label for="code" class="col-sm-2 col-form-label">CODE:</label>
            <div class="col-sm-10">
                <form:input path="code" id="code" class="form-control"/>
                <form:errors path="code" cssClass="error"/>
            </div>
        </div>

        <div class="form-group row">
            <div class="col-sm-10 offset-sm-2">
                <c:choose>
                    <c:when test="${edit}">
                        <button type="submit" class="btn btn-primary">Update</button>
                    </c:when>
                    <c:otherwise>
                        <button type="submit" class="btn btn-primary">Register</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>

    <br/>
    <br/>
    Go back to <a href="<c:url value='/list' />">List of All Students</a>
</div>

</body>
</html>

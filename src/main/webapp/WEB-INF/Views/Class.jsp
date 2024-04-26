<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fitness App</title>
</head>
<body>
    <table>
        <tr>
            <th>ID</th>
            <th>Theme</th>
        </tr>
        <c:forEach items="${exercises}" var="exercise" varStatus="status">
            <tr>
                <td>${exercise.getTitle()}</td>
                <td>${exercise.getMuscleGroup()}</td>

            </tr>
        </c:forEach>
    </table>
    </div>
</body>
</html>




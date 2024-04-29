<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FitTrackr</title>
    <style>
        /* Add your CSS styles here */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 960px;
            margin: 0 auto;
            padding: 20px;
        }
        header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding-bottom: 20px;
            border-bottom: 1px solid #ccc;
        }
        #title {
            text-align: center;
            color: #333;
        }
        nav {
            display: flex;
            justify-content: center;
            align-items: center;
        }
        nav a {
            margin: 0 10px;
            text-decoration: none;
            color: #333;
        }
    </style>
</head>
<body>
    <div class="container">
        <header>
            <h1 id="title">FitTrackr</h1>
            <nav>
                <a href="/activitylog">Activity Log</a>
                <a href="/createWorkout">Create Workout</a>
                <a href="/class">Classes</a>
                <a href="/loginLink">Logout</a>
                <!-- Add more navigation links if needed -->
            </nav>
        </header>
        <main>
            <h1>Welcome ${username}</h1>
            <h3>Height: ${height}</h3>
            <h3>Weight: ${weight}</h3>
            <h3>BMI: ${bmi}</h3>
            <h3>Weight range: ${bmi_class}</h3>
        </main>
        <footer>
            <p>&copy; 2024 FitTrackr. All rights reserved.</p>
        </footer>
    </div>
</body>
</html>

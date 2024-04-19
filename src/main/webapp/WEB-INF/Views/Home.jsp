<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fitness App</title>
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
        h1 {
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
        /* Add more styles as needed */
    </style>
</head>
<body>
    <div class="container">
        <header>
            <h1>Fitness App</h1>
            <nav>
                <a href="#workouts">Today's Workouts</a>
                <a href="#progress">Progress</a>
                <a href="#community">Community</a>
                <!-- Add more navigation links if needed -->
            </nav>
        </header>
        <main>
            <section id="workouts">
                <h2>Today's Workouts</h2>
                <!-- Add content for displaying today's workouts -->
            </section>
            <section id="progress">
                <h2>Progress</h2>
                <!-- Add content for displaying user's fitness progress -->
            </section>
            <section id="community">
                <h2>Community</h2>
                <!-- Add content for displaying community features -->
            </section>
        </main>
        <footer>
            <p>&copy; 2024 Fitness App. All rights reserved.</p>
            <!-- Add additional footer content if needed -->
        </footer>
    </div>
</body>
</html>

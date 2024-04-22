<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <!-- import sql query from java file -->
<%@ page import ="com.CS440.FitnessTracker.Services.ActivityLog" %>
<%@ page import = "java.sql.ResultSet" %>

 <!-- used formatting from jsp other pages and added table formatting for activity log in the body of html -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fitness App</title>
    <style>
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
    </style>
</head>
<body>
    <div class="container">
        <header>
            <h1>Fitness App</h1>
            <nav>
                <a href="/activitylog">Today's Workouts</a>
                <a href="#progress">Progress</a>
                <a href="#community">Community</a>
            </nav>
        </header>
        <main>
            <h2>Activity Log</h2>
            <div>
             <!-- create results table -->
            <% 
                ActivityLog activities = new ActivityLog();
                ResultSet resultsTable = activities.getActivityLog();
            %>
             <!-- display each line on the page -->
            <div>
       
<table>
    <thead>
        <tr>
            <th>Start Time</th>
            <th>End Time</th>
            <th>Exercise</th>
            <th>Sets</th>
            <th>Repetitions</th>
            <th>Weight</th>
            <th>Date</th>
            <th>Time</th>
        </tr>
        <% while(resultsTable.next()) { %>
        <tr>
            <td><%= resultsTable.getString("StartTime") %></td>
            <td><%= resultsTable.getString("EndTime") %></td>
            <td><%= resultsTable.getString("Title") %></td>
            <td><%= resultsTable.getInt("Sets") %></td>
            <td><%= resultsTable.getInt("Repetitions") %></td>
            <td><%= resultsTable.getInt("Weight")%></td>
            <td><%= resultsTable.getString("Date") %></td>
            <td><%= resultsTable.getString("Time") %></td>
        </tr>
        <% } %>
    </thead>
</table>

            </div>
        </div>
        </main>
        <footer>
            <p>&copy; 2024 Fitness App. All rights reserved.</p>
        </footer>
    </div>
</body>
</html>
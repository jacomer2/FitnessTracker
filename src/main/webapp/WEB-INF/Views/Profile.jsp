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
 
         .search-container {
             background-color: #fff;
             border-radius: 8px;
             box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
             padding: 20px;
             max-width: 700px;
             margin: 20px auto;
         }
 
         h2 {
             margin-bottom: 20px;
             color: #333;
         }
 
         input[type="text"],
         select {
             width: 100%;
             padding: 10px;
             margin-bottom: 20px;
             border: 1px solid #ccc;
             border-radius: 4px;
             box-sizing: border-box;
         }
 
         input[type="submit"] {
             background-color: #2922a8;
             color: white;
             padding: 12px 20px;
             border: none;
             border-radius: 4px;
             cursor: pointer;
             width: 100%;
             font-size: 16px;
         }
 
         input[type="submit"]:hover {
             background-color: #45a049;
         }
 
         hr {
             margin: 20px auto;
             /* Center the horizontal rule */
             border: 0;
             height: 1px;
             background-color: #ccc;
             width: 80%;
         }
 
         table {
             width: 100%;
             border-collapse: collapse;
             margin-top: 20px;
         }
 
         th,
         td {
             border: 1px solid #ddd;
             padding: 8px;
             text-align: left;
         }
 
         th {
             background-color: #f2f2f2;
         }
 
         h1 a {
             text-decoration: none;
             color: #333;
 
         }
 
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
            <h1 id="title"><a href="/homeLink">FitTrackr</a></h1>
            <nav>
                <a href="/activitylog">Activity Log</a>
                <a href="/createWorkout">Create Workout</a>
                <a href="/class">Classes</a>
                <a href="/About">About</a>
                <a href="/Profile">Profile</a>
                <a href="/loginLink">Logout</a>
            </nav>
        </header>
        <main>
            <div class="login-container">
            <form action="/profileUpdate" method="post">
                <label for="height"><h2>Height:</h2></label>
                <input type="text" id="height" name="height" placeholder="Current: ${height}" required>
                <label for="weight"><h2>Weight:</h2></label>
                <input type="text" id="weight" name="weight" placeholder="Current: ${weight}" required>
                <input type="submit" value="Update">
            </form>
        </div>
        </main>
        <footer>
            <p>&copy; 2024 FitTrackr. All rights reserved.</p>
        </footer>
    </div>
</body>
</html>

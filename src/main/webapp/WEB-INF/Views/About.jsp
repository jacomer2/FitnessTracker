<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


 <!-- used formatting from jsp other pages and added table formatting for activity log in the body of html -->
 <!DOCTYPE html>
 <html lang="en">
 
 <head>
     <meta charset="UTF-8">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <title>Fitness Tracker - Search</title>
     <style>
         /* body {
             font-family: 'Times New Roman', Times, serif;
             background-color: #f1f1f1;
             margin: 0;
             padding: 0;
         } */
 
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
            <h1 class="header-link"><a href="/Home">FitTrackr</a></h1>
            <nav>
                <a href="/createWorkout">Create Workout</a>
                <a href="/class">Classes</a>
                <a href="/loginLink">Logout</a>
            </nav>
        </header>
        <main>
            <h2>About FitTrackr</h2>
            <div>
                <br/>
                This application is a fitness tracker that allows you to track your exercises. Additionally, you can track your weight and BMI to help you meet your fitness goals. 
                <br/>
                <br/>
                <br/>
            </div>
            <h2>Exercises That We Offer</h2>
            <div>
                             <!-- create results table -->
                <table>
                    <tr>

                        <th>Title</th>
                        <th>Category</th>
                        <th>Description</th>
                        <th>Muscle Group</th>
                        <th>Difficulty</th>

                    </tr>
                    <c:forEach items="${exercise_list}" var="exercise_list" varStatus="status">
                        <tr>
                            <td>${exercise_list.getTitle()}</td>
                            <td>${exercise_list.getCategory()}</td>
                            <td>${exercise_list.getDescription()}</td>
                            <td>${exercise_list.getMuscleGroup()}</td>
                            <td>${exercise_list.getDifficulty()}</td>
                        </tr>
                    </c:forEach>
                </table>
        </div>
        </main>
        <footer>
            <p>&copy; 2024 Fitness App. All rights reserved.</p>
        </footer>
    </div>
</body>
</html>
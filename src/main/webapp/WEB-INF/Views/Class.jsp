<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

                h1 a {
                    text-decoration: none;
                    color: #333;

                }

                footer {
                    margin-top: 20px;
                    padding-top: 20px;
                    padding-left: 160px;
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

                .class-table {
                    width: 100%;
                    border-collapse: collapse;
                    margin-top: 20px;
                }

                .class-table th,
                .class-table td {
                    border: 1px solid #ddd;
                    padding: 8px;
                    text-align: left;
                }

                .class-table th {
                    background-color: #f2f2f2;
                }
            </style>
        </head>

        <body>
            <div class="container">

                <header>
                    <h1 class="header-link"><a href="/homeLink">FitTrackr</a></h1>
                    <nav>
                        <a href="/activitylog">Activity Log</a>
                        <a href="/createWorkout">Create Workout</a>
                        <a href="/loginLink">Logout</a>
                    </nav>
                </header>

                <h2>Classes</h2>
                <table class="class-table">
                    <tr>
                        <th>Class</th>
                        <th>Price</th>
                        <th>Duration</th>
                        <th>Date</th>
                    </tr>
                    <c:forEach items="${classes}" var="class" varStatus="status">
                        <tr>
                            <td>${class.getClassification()}</td>
                            <td>$${class.getPrice()}0</td>
                            <td>${class.getDuration().intValue()} hour</td>
                            <td>${class.getDate().toString()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <footer>
                <p>&copy; 2024 FitTrackr. All rights reserved.</p>
                <!-- Add additional footer content if needed -->
            </footer>

            </div>
        </body>

        </html>
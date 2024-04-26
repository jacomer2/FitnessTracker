<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            max-width: 600px;
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

        h1,
        h2,
        h3,
        p {
            text-align: center;
            /* Center align the content */
            font-family: 'Times New Roman', Times, serif;
            /* Change font */
            margin-top: 20px;
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
    </style>

    
            <!-- <script>
        document.getElementById("searchForm").addEventListener("submit", function(event) {
        event.preventDefault();

        // Get form data
        var formData = new FormData(this);

        // Create a new row for the table
        var newRow = "<tr>";
        newRow += "<td>" + (document.getElementById("tableBody").rows.length + 1) + "</td>";
        newRow += "<td>" + formData.get("category") + "</td>";
        newRow += "<td>" + formData.get("muscle_group") + "</td>";
        newRow += "<td>" + formData.get("difficulty") + "</td>";
        newRow += "<td>" + formData.get("description") + "</td>";
        newRow += "</tr>";

        // Append the new row to the table body
        document.getElementById("tableBody").innerHTML += newRow;

        // Reset form
        this.reset();
        });
        </script> -->
</head>

<body>
    <div class="container">
    <header>
        <h1>Fitness App</h1>
        <nav>
            <a href="/activitylog">Workout History</a>
            <a href="/createWorkout">Create Workout</a>
            <a href="#community">Community</a>
            <a href="/loginLink">LoginTest</a>
            <a href="/sandbox">Sandbox</a>
            <!-- Add more navigation links if needed -->
        </nav>
    </header>

    <h1>Build your workout</h1>
    <hr>
    <br>
    <div class="search-container">
        <h2>Search Fitness Tracker</h2>
        <form id="searchForm">
            <select name="category" required>
                <option value="" selected disabled>Choose category</option>
                <option value="bodyweight">Bodyweight</option>
                <option value="cardio">Cardio</option>
                <option value="resistance">Resistance</option>
            </select>
            <select name="muscle_group" required>
                <option value="" selected disabled>Choose muscle group</option>
                <option value="legs">Legs</option>
                <option value="chest">Chest</option>
                <option value="back">Back</option>
                <option value="full body">Full Body</option>
                <option value="core">Core</option>
                <option value="shoulders">Shoulders</option>
            </select>
            <select name="difficulty" required>
                <option value="" selected disabled>Choose difficulty</option>
                <option value="easy">Easy</option>
                <option value="medium">Medium</option>
                <option value="hard">Hard</option>
            </select>
            <input type="text" name="description" placeholder="Description" required>
            <input type="submit" value="Submit">
        </form>

        <table id="dataTable">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Category</th>
                    <th>Muscle Group</th>
                    <th>Difficulty</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody id="tableBody">
            </tbody>
        </table>
    </div>
    </div>
</body>

</html>
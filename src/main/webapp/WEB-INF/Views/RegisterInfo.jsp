<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>RegisterInfo</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f1f1f1;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
  }
  .login-container {
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    padding: 40px;
    width: 300px;
    max-width: 90%;
    text-align: center;
  }
  .regLink {
    padding-top: 1%;
    padding-bottom: -5px;
  }
  h2 {
    margin-bottom: 20px;
    color: #333;
  }
  input[type="text"],
  input[type="password"] {
    width: calc(100% - 20px);
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

  #error {
    color: red;
  }
</style>
</head>
<body>
<div class="register-container">
  <h2>Register your info</h2>
  <form action="/RegisterInfo" method="post">
    <h3>Name: ${name}</h3>
    <h3>Username: ${username}</h3>
    <input type="number" name="height" placeholder="Height (ex: 70)" required>
    <input type="number" name="weight" placeholder="Weight (ex: 150)" required>
    <input type="submit" value="Register">
  </form>

  <p id="error">${error}</p>
</div>
</body>
</html>
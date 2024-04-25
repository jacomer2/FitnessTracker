<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Page</title>
<style>
  body {
    font-family: Arial, sans-serif;
    /* Background gradient */
    background: linear-gradient(to right, #667db6, #0082c8, #0082c8, #667db6);
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    /* Text shadow for better readability */
    text-shadow: 1px 1px 2px rgba(0,0,0,0.5);
    color: #fff;
  }
  .login-container {
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    padding: 40px;
    width: 300px;
    max-width: 90%;
    text-align: center;
    /* Transparent background with slight opacity */
    background-color: rgba(255, 255, 255, 0.9);
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
</style>
</head>
<body>
<div class="login-container">
  <h2>Login</h2>
  <form action="#" method="post">
    <input type="text" name="username" placeholder="Username" required>
    <input type="password" name="password" placeholder="Password" required>
    <input type="submit" value="Login">
  </form>
</div>
<!-- Relevant Text Added to the Background -->
<div style="position: absolute; top: 20px; left: 20px;">
  <h1>Welcome to Our Fitness App Portal</h1>
  <p>Please enter your credentials to access your account.</p>
</div>
</body>
</html>
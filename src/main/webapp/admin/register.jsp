<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
<div class="container">
    <div class="login-wrapper">
        <div class="header">Register</div>
        <form class="form-wrapper" action="${pageContext.request.contextPath}/register" method="post">
            <span style="color: red">${msg}</span>
            <label>
                <input type="text" name="username" placeholder="username" class="input-item">
            </label>

            <label>
                <input type="password" name="password" placeholder="password" class="input-item">
            </label>
            <button type="submit" class="btn" formtarget="_self">Sign Up</button>
        </form>
    </div>
</div>
</body>
</html>


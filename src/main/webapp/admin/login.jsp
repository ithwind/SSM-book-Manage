<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
    <link rel="icon" href="${pageContext.request.contextPath}/bootstrap-icons-1.10.5/person.svg" />
</head>
<body>
<div class="container">
    <div class="login-wrapper">
        <div class="header">Login</div>
        <span style="color: red">${msg}</span>
        <form class="form-wrapper" action="${pageContext.request.contextPath}/login" method="post">
            <label>
                <input type="text" name="username" placeholder="username" class="input-item">
            </label>
            <label>
                <input type="password" name="password" placeholder="password" class="input-item">
            </label>
            <button type="submit" class="btn" formtarget="_self">Login</button>
        </form>
        <div class="msg">
            Don't have account?
            <a href="<c:url value="/admin/register.jsp"/>">Sign up</a>
        </div>
    </div>
</div>
</body>
</html>

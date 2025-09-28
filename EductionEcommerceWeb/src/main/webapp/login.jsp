<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - EduMart</title>
<style>
.container {
    max-width: 400px;
    margin: 80px auto;
    padding: 25px;
    background: #fff;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0,0,0,0.1);
}
h2 {
    text-align: center;
    margin-bottom: 20px;
}
input[type=text], input[type=password], input[type=email] {
    width: 100%;
    padding: 12px;
    margin: 10px 0;
    border: 1px solid #ddd;
    border-radius: 6px;
}
input[type=submit] {
    width: 100%;
    background: #1abc9c;
    color: white;
    border: none;
    padding: 12px;
    font-size: 16px;
    border-radius: 6px;
    cursor: pointer;
}
input[type=submit]:hover {
    background: #16a085;
}
</style>

</head>
<body>
<%@ include file="header.jsp" %>

<div class="container">
    <h2>Login</h2>
    <form method="post" action="login">
        <label>Username</label><br>
        <input type="text" name="username" required/><br><br>
        <label>Password</label><br>
        <input type="password" name="password" required/><br><br>
        <input type="submit" value="Login" class="btn btn-primary"/>
    </form>
    <p style="color:red">${error}</p>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register - EduMart</title>

</head>
<body>
<%@ include file="header.jsp" %>

<div class="container">
    <h2>Register</h2>
    <form method="post" action="register">
        <label>Full Name</label><br>
        <input type="text" name="fullname" required/><br><br>
        <label>Email</label><br>
        <input type="email" name="email" required/><br><br>
        <label>Password</label><br>
        <input type="password" name="password" required/><br><br>
        <input type="submit" value="Register" class="btn btn-primary"/>
    </form>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>

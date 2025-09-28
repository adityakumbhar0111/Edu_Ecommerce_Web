<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment Successful - EduMart</title>
	<style>
.container {
    max-width: 700px;
    margin: 40px auto;
    padding: 25px;
    background: #fff;
    border-radius: 10px;
    box-shadow: 0 5px 12px rgba(0,0,0,0.1);
}
h2 {
    margin-bottom: 20px;
    text-align: center;
}
label {
    font-weight: 600;
}
input, select {
    width: 100%;
    padding: 12px;
    margin: 10px 0;
    border: 1px solid #ccc;
    border-radius: 6px;
}
.btn-pay {
    background: #3498db;
    color: #fff;
    padding: 12px;
    width: 100%;
    border: none;
    border-radius: 6px;
    cursor: pointer;
    font-size: 16px;
}
.btn-pay:hover {
    background: #2980b9;
}
</style>
	
</head>
<body>
<%@ include file="header.jsp" %>

<div class="container">
    <h2>Payment Successful</h2>
    <p>Thank you for purchasing the course. Your enrollment details have been sent to your email.</p>
    <a href="index.jsp" class="btn btn-primary">Go to Home</a>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Contact Us - EduMart</title>
  <style>
.container {
    max-width: 600px;
    margin: 50px auto;
    padding: 25px;
    background: #fff;
    border-radius: 10px;
    box-shadow: 0 5px 12px rgba(0,0,0,0.1);
}
h2 {
    text-align: center;
    margin-bottom: 20px;
}
input, textarea {
    width: 100%;
    padding: 12px;
    margin: 10px 0;
    border: 1px solid #ddd;
    border-radius: 6px;
}
input[type=submit] {
    background: #1abc9c;
    color: white;
    border: none;
    padding: 12px;
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
    <h2>Contact Us</h2>
    <p>Email: support@edumart.com</p>
    <p>Phone: +91 98765 43210</p>
    <p>Address: EduMart HQ, Bengaluru, India</p>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>

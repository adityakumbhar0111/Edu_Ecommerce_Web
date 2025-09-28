<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>EduMart - Home</title>
   	<style>
body {
    font-family: 'Segoe UI', sans-serif;
    background: #f4f6f9;
    margin: 0;
    padding: 0;
}
.container {
    max-width: 1000px;
    margin: 40px auto;
    padding: 25px;
    text-align: center;
}
.hero {
    background: linear-gradient(135deg, #1abc9c, #3498db);
    color: white;
    padding: 80px 20px;
    border-radius: 10px;
    margin-bottom: 30px;
}
.hero h2 {
    font-size: 32px;
    margin-bottom: 15px;
}
.hero p {
    font-size: 18px;
}
</style>

</head>
<body>
<%@ include file="header.jsp" %>

<div class="container">
    <h2>Welcome to EduMart</h2>
    <p>Your one-stop platform to purchase educational courses, materials, and resources online.</p>

    <h3>Featured Courses</h3>
    <div class="products">
        <div class="product-card">
            <img src="images/java.jpg" alt="Java">
            <h3>Java Programming</h3>
            <p>Learn Java from basics to advanced concepts.</p>
            <a href="products.jsp" class="btn btn-primary">View Course</a>
        </div>
        <div class="product-card">
            <img src="images/python.jpg" alt="Python">
            <h3>Python for Beginners</h3>
            <p>Step into the world of Python programming.</p>
            <a href="products.jsp" class="btn btn-primary">View Course</a>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>

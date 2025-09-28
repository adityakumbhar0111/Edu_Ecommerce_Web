<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Achievements - EduMart</title>
   <style>
.container {
    max-width: 1000px;
    margin: 40px auto;
    padding: 20px;
}
.achievements {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
    gap: 20px;
}
.achievement-card {
    background: #fff;
    padding: 20px;
    border-radius: 10px;
    text-align: center;
    box-shadow: 0 4px 12px rgba(0,0,0,0.1);
}
.achievement-card h3 {
    color: #1abc9c;
    margin-bottom: 10px;
}
</style>
   
</head>
<body>
<%@ include file="header.jsp" %>

<div class="container">
    <h2>Our Achievements</h2>
    <ul>
        <li>Trained over 50,000 students worldwide.</li>
        <li>Partnered with 100+ universities and institutes.</li>
        <li>Awarded “Best EdTech Startup 2024”.</li>
        <li>Launched 200+ professional certification courses.</li>
    </ul>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>

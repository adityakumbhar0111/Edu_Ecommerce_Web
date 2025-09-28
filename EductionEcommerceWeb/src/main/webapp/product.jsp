<%@ page import="model.Product" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Details - EduMart</title>
 
</head>
<body>
<%@ include file="header.jsp" %>

<div class="container">
    <%
        Product p = (Product) request.getAttribute("product");
        if (p != null) {
    %>
        <h2><%=p.getName()%></h2>
        <img src="<%=p.getImageUrl()%>" alt="<%=p.getName()%>" style="width:300px;">
        <p><%=p.getDescription()%></p>
        <p><b>₹<%=p.getPrice()%></b></p>
        <a href="cart?action=add&id=<%= p.getId() %>" class="btn btn-primary">Add to Cart</a>
    <% } else { %>
        <p>Product not found.</p>
    <% } %>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>

<%@ page import="java.util.*,model.Product" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Courses - EduMart</title>
 	<style>
.container {
    max-width: 1000px;
    margin: 30px auto;
    padding: 20px;
}
.products {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
    gap: 20px;
}
.product-card {
    background: #fff;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0,0,0,0.1);
    text-align: center;
    transition: 0.3s;
}
.product-card:hover {
    transform: translateY(-5px);
}
.product-card img {
    max-width: 100%;
    border-radius: 6px;
}
.product-card h3 {
    margin: 15px 0 10px;
}
.btn {
    background: #1abc9c;
    color: white;
    padding: 8px 14px;
    border-radius: 6px;
    text-decoration: none;
    transition: 0.3s;
}
.btn:hover {
    background: #16a085;
}
</style>
 	
</head>
<body>
<%@ include file="header.jsp" %>

<div class="container">
    <h2>Available Courses</h2>
    <div class="products">
        <%
            List<Product> products = (List<Product>) request.getAttribute("products");
            if (products != null) {
                for(Product p : products) {
        %>
        <div class="product-card">
            <img src="<%=p.getImageUrl()%>" alt="<%=p.getName()%>">
            <h3><%=p.getName()%></h3>
            <p>₹<%=p.getPrice()%></p>
            <a href="cart?action=add&id=<%= p.getId() %>" class="btn btn-primary">Add to Cart</a>
        </div>
        <% } } else { %>
        <p>No products found.</p>
        <% } %>
    </div>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>

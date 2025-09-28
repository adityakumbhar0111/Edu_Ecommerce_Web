<%@ page import="java.util.*,model.Product" %>
<%@ include file="header.jsp" %>
<html>
<head>
<style>
.container {
    max-width: 900px;
    margin: 40px auto;
    padding: 25px;
    background: #fff;
    border-radius: 12px;
    box-shadow: 0 4px 12px rgba(0,0,0,0.1);
}
h2 {
    text-align: center;
    margin-bottom: 25px;
}
table {
    width: 100%;
    border-collapse: collapse;
}
th, td {
    padding: 14px;
    border-bottom: 1px solid #ddd;
}
th {
    background: #1abc9c;
    color: #fff;
}
.btn-remove {
    background: #e74c3c;
    color: #fff;
    padding: 6px 12px;
    border-radius: 6px;
    text-decoration: none;
}
.btn-remove:hover {
    background: #c0392b;
}
.total {
    text-align: right;
    font-size: 18px;
    font-weight: bold;
    margin-top: 20px;
}
</style>

</head>
<div class="container">
    <h2>Your Cart</h2>
    <%
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null || cart.isEmpty()) {
    %>
        <p class="empty">Your cart is empty.</p>
        <a href="products" class="btn btn-shop">Browse Courses</a>
    <%
        } else {
            double total = 0;
    %>
        <table>
            <tr>
                <th>Course</th>
                <th>Price (₹)</th>
                <th>Action</th>
            </tr>
            <%
                for (Product c : cart) {
                    total += c.getPrice();
            %>
            <tr>
                <td><%= c.getName() %></td>
                <td>₹<%= c.getPrice() %></td>
                <td><a href="cart?action=remove&id=<%= c.getId() %>" class="btn btn-remove">Remove</a></td>
            </tr>
            <% } %>
        </table>
        <div class="total">Total: ₹<%= total %></div>
        <div class="center">
            <a href="products" class="btn btn-shop">Continue Shopping</a>
            <a href="checkout.jsp" class="btn btn-primary">Proceed to Checkout</a>
        </div>
    <% } %>
</div>
<%@ include file="footer.jsp" %>

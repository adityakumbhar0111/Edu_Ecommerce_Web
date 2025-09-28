<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html>
<head>
</head>
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
<div class="container">
    <h2>Checkout</h2>
    <form method="post" action="payment.jsp">
        <label>Full Name</label><br>
        <input type="text" name="fullname" required/><br><br>
        <label>Email</label><br>
        <input type="email" name="email" required/><br><br>
        <input type="submit" value="Proceed to Payment" class="btn btn-primary"/>
    </form>
</div>
<%@ include file="footer.jsp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
    font-family: Arial, sans-serif;
    margin: 20px;
    padding: 20px;
}
.container {
    max-width: 500px;
    margin: 0 auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
h2 {
    text-align: center;
}
.form-group {
    margin-bottom: 15px;
}
.form-group label {
    display: block;
    margin-bottom: 5px;
}
.form-group input {
    width: 100%;
    padding: 8px;
    box-sizing: border-box;
}
.form-group input[type="date"] {
    padding: 6px;
}
.form-group button {
    width: 100%;
    padding: 10px;
    background-color: #28a745;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}
.form-group button:hover {
    background-color: #218838;
}</style>
</head>
<body>
	<div class="container">
        <h2>Product Register Form</h2>
        <form action="productRegister">
            <div class="form-group">
                <label for="product-id">Product ID</label>
                <input type="text" id="product-id" name="id"  placeholder="Product ID">
            </div>
            <div class="form-group">
                <label for="product-name">Product Name</label>
                <input type="text" id="product-name" name="name"  placeholder="Product Name">
            </div>
            <div class="form-group">
                <label for="product-price">Product Price</label>
                <input type="number" id="product-price" name="price"  placeholder="Product Price">
            </div>
            <div class="form-group">
                <label for="mfd">Manufacturing Date (MFD)</label>
                <input type="date" id="mfd" name="mfd"  placeholder="Manufacturing Date">
            </div>
            <div class="form-group">
                <label for="expd">Expiry Date (EXPD)</label>
                <input type="date" id="expd" name="expd"  placeholder="Expiry Date">
            </div>
            <div class="form-group">
                <button type="submit">Register</button>
            </div>
        </form>
    </div>
</body>
</html>
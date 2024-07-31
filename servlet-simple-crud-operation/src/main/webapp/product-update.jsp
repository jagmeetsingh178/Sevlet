<%@page import="com.jsp.servlet_simple_crud_operation.dto.Product"%>
<%@page import="com.jspider.jdbc_prepared_statement_crud_operation.dao.ProductDao"%>
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

	<%
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = new ProductDao().getProductByIdDao(id);
	%>

	<div class="container">
        <h2>Product Update Form</h2>
        <form action="productUpdate">
            <div class="form-group">
                <label for="product-id">Product ID</label>
                <input type="text" name="id" value="<%=product.getId()%>">
            </div>
            <div class="form-group">
                <label for="product-name">Product Name</label>
                <input type="text"  name="name" value="<%=product.getName()%>">
            </div>
            <div class="form-group">
                <label for="product-price">Product Price</label>
                <input type="number"  name="price" value="<%=product.getPrice()%>">
            </div>
            <div class="form-group">
                <label for="mfd">Manufacturing Date (MFD)</label>
                <input type="date"  name="mfd" value="<%=product.getMfd()%>">
            </div>
            <div class="form-group">
                <label for="expd">Expiry Date (EXPD)</label>
                <input type="date"  name="expd" value="<%=product.getExpd()%>">
            </div>
            <div class="form-group">
                <button type="submit">Update</button>
            </div>
        </form>
    </div>
</body>
</html>
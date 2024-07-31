<%@page import="java.util.List"%>
<%@page import="com.jspider.jdbc_prepared_statement_crud_operation.dao.ProductDao"%>
<%@page import="com.jsp.servlet_simple_crud_operation.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>

/* style.css */
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f9;
	margin: 0;
	padding: 0;
}

.container {
	max-width: 800px;
	margin: 50px auto;
	background: #fff;
	padding: 20px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	border-radius: 8px;
}

h2 {
	text-align: center;
	color: #333;
	margin-bottom: 20px;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin: 25px 0;
	font-size: 18px;
	text-align: left;
}

table th, table td {
	padding: 12px 15px;
	border: 1px solid #ddd;
}

table th {
	background-color: #f2f2f2;
	font-weight: bold;
}

table tbody tr:nth-child(even) {
	background-color: #f9f9f9;
}
</style>
</head>
<body>

		<%
			ProductDao dao = new ProductDao();
			List<Product> products = dao.displayAllProductDataDao();
		%>


	<div class="container">
		<h2>Product Display Table</h2>
		<table>
			<thead>
				<tr>
					<th>Product ID</th>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Manufacturing Date (MFD)</th>
					<th>Expiry Date (EXPD)</th>
					<th colspan="2">Action</th>
				</tr>
			</thead>
			<% for(Product product : products){ %>
			<tbody>
				<tr>
					<td><%=product.getId()%></td>
					<td><%=product.getName()%></td>
					<td><%=product.getPrice() %></td>
					<td><%=product.getMfd() %></td>
					<td><%=product.getExpd() %></td>
					<td> <a href="delete?id=<%=product.getId()%>"><button>DELETE</button></a> </td>
					<td> <a href="product-update.jsp?id=<%=product.getId()%>"><button>UPDATE</button></a></td>
				</tr>
			</tbody>
			<%}%>
		</table>
	</div>
</body>
</html>
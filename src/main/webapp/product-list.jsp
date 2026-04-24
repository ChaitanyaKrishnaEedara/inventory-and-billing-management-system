<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.model.Product, com.dao.ProductDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<title>Products list</title>
</head>
<body>
	<h2>List of all products</h2>
	<table class="table">
		<tr>
			<th>Product ID</th>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity in stock</th>
			<th>Status</th>
			<th colspan="2">Action</th>
		</tr>
		<%
		ProductDAO dao = new ProductDAO();
		List<Product> products = dao.getAllProducts();
		%>
		<%
		for (Product p : products) {
		%>
		<tr>
			<td><%=p.getProductId()%></td>
			<td><%=p.getName()%></td>
			<td>₹. <%=p.getPrice()%></td>
			<td><%=p.getQuantityInStock()%> units</td>
			<td><%=p.getStatus()%></td>
			<td><a
				href="edit-product.jsp?pid=<%=p.getProductId()%>&name=<%=p.getName()%>&price=<%=p.getPrice()%>&status=<%=p.getStatus()%>"><button
						type="button">Edit</button></a></td>
			<%-- <td><a href="#"><button type="button">Delete</button></a></td> --%>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>
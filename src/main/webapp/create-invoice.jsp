<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.dao.ProductDAO, com.model.Product" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<title>Insert title here</title>
	</head>
	<body>
		<%
			ProductDAO dao = new ProductDAO(); 
			List<Product> products = dao.getAllActiveProducts();
		%>
		<form name="create-invoice" method="get" action="CreateInvoiceServlet">
			<div>
				<label>Customer name:</label>
				<input type="text" name="customerName" id="customerName" required>
			</div>
			<div>
				<label>Customer phone:</label>
				<input type="text" name="customerPhone" id="customerPhone" required>
			</div>
			<div>
				<label>Customer email:</label>
				<input type="text" name="customerEmail" id="customerEmail" required>
			</div>
			<div>
				<label>Select product: </label>
				<select name="productId" required>
					<% for(Product p:products) { %>
						<option value="<%= p.getProductId() %>"> <%= p.getName() %> - ₹. <%= p.getPrice() %> - <%= p.getQuantityInStock() %> stock left </option>
					<% } %>
				</select>
			</div>
			<div>
				<label>Quantity: </label>
				<input type="number" name="quantity" id="quantity" min="1" required>
			</div>
			<button type="submit">Generate Invoice</button>
		</form>
	</body>
</html>
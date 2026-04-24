<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.model.Invoice, com.dao.InvoiceDAO" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<title>Your invoices</title>
	</head>
	<body>
		<% String username = (String)session.getAttribute("username"); %>
		<h1>Welcome <i><%= username %></i></h1>
		<p>Here are the invoices created by you</p>
		
		<table class="table table-bordered">
			<tr>
				<th>Invoice ID</th>
				<th>User Name</th>
				<th>Customer Name</th>
				<th>Customer Phone</th>
				<th>Customer Email</th>
				<th>Product ID</th>
				<th>Quantity</th>
				<th>Invoice Date</th>
			</tr>
			<%
				InvoiceDAO dao = new InvoiceDAO();
				List<Invoice> invoices = dao.getInvoicesByUsername(username);
			%>
			<% for(Invoice i:invoices){ %>
				<tr>
					<td><%= i.getInvoiceId() %></td>
					<td><%= i.getUserName() %></td>
					<td><%= i.getCustomerName() %></td>
					<td><%= i.getCustomerPhone() %></td>
					<td><%= i.getCustomerEmail() %></td>
					<td><%= i.getProductId() %></td>
					<td><%= i.getQuantity() %></td>
					<td><%= i.getInvoiceDate() %></td>
				</tr>
			<% } %>
		</table>
	</body>
</html>
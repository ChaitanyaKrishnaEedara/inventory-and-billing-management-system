<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.dao.InvoiceDAO, com.model.Invoice" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
		<title>Invoices list</title>
	</head>
	<body>
		<%
			InvoiceDAO dao = new InvoiceDAO();
			List<Invoice> invoices = dao.getInvoicesByUsername((String)session.getAttribute("username"));
		%>
		<table>
			<tr>
				<th>Invoice ID</th>
				<th>Staff name</th>
				<th>Customer name</th>
				<th>Customer phone</th>
				<th>Customer email</th>
				<th>Product ID</th>
				<th>Quantity</th>
				<th>Invoice date</th>
				<th>Total amount</th>
			</tr>
			<%	for(Invoice invoice : invoices) { %>
				<tr>
					<td><%= invoice.getInvoiceId() %></td>
					<td><%= invoice.getUserName() %></td>
					<td><%= invoice.getCustomerName() %></td>
					<td><%= invoice.getCustomerPhone() %></td>
					<td><%= invoice.getCustomerEmail() %></td>
					<td><%= invoice.getProductId() %></td>
					<td><%= invoice.getQuantity() %></td>
					<td><%= invoice.getInvoiceDate() %></td>
					<td><%= invoice.getTotalAmount() %></td>
				</tr>
			<%	} %>
		</table>
	</body>
</html>
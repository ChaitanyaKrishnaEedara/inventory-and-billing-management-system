<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<meta charset="UTF-8">
	<title>Stock log</title>
	</head>
	<body>
		<form name="AddStockLog" method="post" action="AddStockLogServlet">
			<div>
				<label>Product ID: </label>
				<input type="number" name="productId" id="productId" value="<%= request.getAttribute("productId") %>" placeholder="<%= request.getAttribute("productId") %>" readonly>
			</div>
			<div>
				<label>Change quantity: </label>
				<input type="number" name="changeQty" id="changeQty" value="-<%= request.getAttribute("quantity") %>" placeholder="-<%= request.getAttribute("quantity") %>" readonly>
			</div>
			<div>
				<label>Reason: </label>
				<input type="text" name="reason" id="reason" required>
			</div>
			<div>
				<label>User Name: </label>
				<input type="text" name="username" id="username" value="<%= session.getAttribute("username") %>" placeholder="<%= session.getAttribute("username") %>" readonly>
			</div>
			<div>
				<label>Invoice ID: </label>
				<input type="number" name="invoiceId" id="invoiceId" value="<%= request.getAttribute("invoiceId") %>" placeholder="<%= request.getAttribute("invoiceId") %>" readonly>
			</div>
			<button type="submit">Add log</button>
		</form>
	</body>
</html>
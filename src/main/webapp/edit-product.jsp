<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<title>Edit product</title>
</head>
<body>
	<form name="updateProduct" method="get" action="EditProductServlet">
		<div>
			<label>Product ID: </label> <input type="number" name="productId"
				id="productId" value="<%=request.getParameter("pid")%>" readonly>
		</div>
		<div>
			<label>Product name:</label> <input type="text" name="name" id="name"
				value="<%=request.getParameter("name")%>" required>
		</div>
		<div>
			<label>Price: ₹</label> <input type="number" name="price" id="price"
				value="<%=request.getParameter("price")%>" required>
		</div>
		<div>
			<label>Set status: </label> <select name="status" id="status">
				<option disabled selected value="">--Select an option--</option>
				<option value="ACTIVE">Active</option>
				<option value="INACTIVE">Inactive</option>
			</select>
		</div>
		<button type="submit" name="btn" id="btn">Update</button>
	</form>
</body>
</html>
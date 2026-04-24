<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Add new product</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	</head>
	<body>
		<form name="addProduct" method="post" action="AddProductServlet">
			<div>
				<label for="name">Product name: </label>
				<input type="text" name="name" id="name" required>
			</div>
			<div>
				<label for="price">Price: ₹</label>
				<input type="number" name="price" id="price" required>
			</div>
			<div>
				<label for="quantity">Quantity in stock: </label>
				<input type="number" name="quantity" id="quantity" required>
			</div>
			<button type="submit" name="submit" id="submit">Add product</button>
		</form>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Admin dashboard</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	</head>
	<body>
		<h1>Welcome <i><%= session.getAttribute("username") %></i></h1>
		<ul>
			<li><a href="add-product.jsp">Add product</a></li>
			<li><a href="product-list.jsp">List all products</a></li>
			<li><a href="add-user.jsp">Add user</a></li>
			<li><a href="user-list.jsp">List all users</a></li>
		</ul>
		
		<a href="LogoutServlet"><button type="button">Logout</button></a>
		
	</body>
</html>
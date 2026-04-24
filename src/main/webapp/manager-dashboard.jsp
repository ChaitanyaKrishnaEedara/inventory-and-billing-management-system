<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Manager dashboard</title>
	</head>
	<body>
		<h1>Welcome <i><%= session.getAttribute("username") %></i></h1>
		<a href="LogoutServlet"><button type="button">Logout</button></a>
	</body>
</html>
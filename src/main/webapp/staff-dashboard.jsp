<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<title>Staff dashboard</title>
	</head>
	<body>
		<h1>Welcome <i><%= session.getAttribute("username") %></i></h1>
		<ul>
			<li><a href="create-invoice.jsp">Create invoice</a></li>
			<li><a href="staff-invoices-list.jsp">List my invoices</a></li>
		</ul>
		
		<a href="LogoutServlet"><button type="button">Logout</button></a>
	</body>
</html>
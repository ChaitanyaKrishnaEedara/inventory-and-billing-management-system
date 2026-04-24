<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Login</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	</head>
	<body>
		<h2>Login</h2>
		<form name="login" method="post" action="LoginServlet">
			<div>
				Username: <input type="text" name="username" id="username" required />
			</div>
			<div>
				Password: <input type="password" name="password" id="password" required />
			</div>
			<input type="submit" value="Login" />
		</form>
	</body>
</html>
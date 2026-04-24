<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	</head>
	<body>
		<form name="addUser" method="post" action="AddUserServlet">
			<div>
				<label for="name">User name: </label>
				<input type="text" name="name" id="name" placeholder="username" required>
			</div>
			<div>
				<label for="password">Password: </label>
				<input type="password" name="password" id="password" placeholder="password" required>
			</div>
			<div>
				<label for="role">Role: </label>
				<select name="role" id="role" required>
			        <option value="1">Admin</option>
			        <option value="2">Staff</option>
			        <option value="3">Manager</option>
			    </select>
			</div>
			<button type="submit" name="submit" id="submit">Add user</button>
		</form>
	</body>
</html>
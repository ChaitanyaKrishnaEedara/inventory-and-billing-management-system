<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="updateProduct" method="post" action="EditUserServlet">
		<div>
			<label>User name: </label> <input type="text" name="userName"
				id="userName" value="<%=request.getParameter("name")%>" readonly>
		</div>
		<div>
			<label>password: </label> <input type="password" name="password"
				id="password" value="<%=request.getParameter("pass")%>" required>
		</div>
		<div>
			<label>Set role: </label> <select name="roleId" id="roleId">
				<option disabled selected value="">--Select an option--</option>
				<option value="1">Admin</option>
				<option value="2">Staff</option>
				<option value="3">Manager</option>
			</select>
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
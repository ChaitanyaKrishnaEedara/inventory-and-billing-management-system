<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.model.User, com.dao.UserDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
	<h2>List of all users</h2>
	<table class="table">
		<tr>
			<th>User name</th>
			<th>Password</th>
			<th>Role</th>
			<th>Status</th>
			<th colspan="2">Action</th>
		</tr>
		<%
		UserDAO dao = new UserDAO();
		List<User> users = dao.getAllUsers();
		%>
		<%
		for (User u : users) {
		%>
		<tr>
			<td><%=u.getUsername()%></td>
			<td><%=u.getPassword()%></td>
			<td><%=u.getRole()%></td>
			<td><%=u.getStatus()%></td>
			<td><a
				href="edit-user.jsp?name=<%=u.getUsername()%>&pass=<%=u.getPassword()%>&role=<%=u.getRoleId()%>&status=<%=u.getStatus()%>"><button
						type="button">Edit</button></a></td>
			<%-- <td><a href="#"><button type="button">Delete</button></a></td> --%>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>
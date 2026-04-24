package com.controller;

import java.io.IOException;

import com.dao.UserDAO;
import com.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		int roleId = Integer.parseInt(request.getParameter("role"));

		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		u.setRoleId(roleId);

		UserDAO dao = new UserDAO();
		String status = dao.addUser(u);

		if (status.equals("success")) {
			System.out.println("user added\n");
			response.sendRedirect("user-list.jsp");
		} else {
			System.out.println("something went wrong\n");
			RequestDispatcher rd = request.getRequestDispatcher("add-user.jsp");
			rd.forward(request, response);
		}
	}

}

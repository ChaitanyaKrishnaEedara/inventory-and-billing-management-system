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
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserDAO dao = new UserDAO();
		User user = dao.login(username, password);

		if (user != null) {
			HttpSession session = request.getSession();
//			session.setAttribute("user", user);
			session.setAttribute("username", username);

			switch (user.getRole()) {
			case "ADMIN" -> response.sendRedirect("admin-dashboard.jsp");
			case "STAFF" -> response.sendRedirect("staff-dashboard.jsp");
			case "MANAGER" -> response.sendRedirect("manager-dashboard.jsp");
			}
		} else {
			request.setAttribute("error", "Invalid credentials");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}

	}

}

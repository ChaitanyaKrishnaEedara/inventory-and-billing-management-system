package com.controller;

import java.io.IOException;
import java.math.BigDecimal;

import com.dao.ProductDAO;
import com.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		int productId = Integer.parseInt(request.getParameter("productId"));
		String name = request.getParameter("name");
		BigDecimal price = new BigDecimal(request.getParameter("price"));
		String pStatus = request.getParameter("status");

		Product p = new Product();
		p.setProductId(productId);
		p.setName(name);
		p.setPrice(price);
		p.setStatus(pStatus);

		ProductDAO dao = new ProductDAO();
		String status = dao.updateProduct(p);

		if (status.equals("success")) {
			System.out.println("product updated\n");
			response.sendRedirect("product-list.jsp");
		} else {
			System.out.println("something went wrong(EditProductServlet)\n");
			response.sendRedirect("product-list.jsp");
		}
	}

}

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

@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		BigDecimal price = new BigDecimal(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		Product p = new Product();
		p.setName(name);
		p.setPrice(price);
		p.setQuantityInStock(quantity);

		ProductDAO dao = new ProductDAO();
		String status = dao.addProduct(p);

		if (status.equals("success")) {
			System.out.println("product added\n");
			response.sendRedirect("product-list.jsp");
		} else {
			System.out.println("something went wrong\n");
			response.sendRedirect("add-product.jsp");
		}
	}

}

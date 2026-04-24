package com.controller;

import java.io.IOException;
import java.math.BigDecimal;

import com.dao.InvoiceDAO;
import com.dao.ProductDAO;
import com.model.Invoice;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CreateInvoiceServlet")
public class CreateInvoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		int productId = Integer.parseInt(request.getParameter("productId"));
		String customerName = request.getParameter("customerName");
		String customerPhone = request.getParameter("customerPhone");
		String customerEmail = request.getParameter("customerEmail");
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		ProductDAO dao = new ProductDAO();
		BigDecimal price = dao.getProductPrice(productId);
		BigDecimal totalAmount = price.multiply(new BigDecimal(quantity));

		String status = dao.updateProductQuantity(productId, quantity);

		if (status.equals("success")) {
			Invoice i = new Invoice();
			HttpSession session = request.getSession();
			i.setUserName((String) session.getAttribute("username"));
			i.setCustomerName(customerName);
			i.setCustomerPhone(customerPhone);
			i.setCustomerEmail(customerEmail);
			i.setProductId(productId);
			i.setQuantity(quantity);
			i.setTotalAmount(totalAmount);

			InvoiceDAO dao2 = new InvoiceDAO();
			int invoiceId = dao2.createInvoice(i);

//			if (invoiceId > -1) {
			System.out.println("invoice created\n");
			request.setAttribute("productId", productId);
			request.setAttribute("quantity", quantity);
			request.setAttribute("username", session.getAttribute("username"));
			request.setAttribute("invoiceId", invoiceId);
			RequestDispatcher rd = request.getRequestDispatcher("staff-stock-log.jsp");
			rd.forward(request, response);

		} else {
			System.out.println("something went wrong\n");
			response.sendRedirect("create-invoice.jsp");
		}
//		}

	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}

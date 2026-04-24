package com.controller;

import java.io.IOException;

import com.dao.StockLogDAO;
import com.model.StockLog;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddStockLogServlet")
public class AddStockLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("productId"));
		int changeQty = Integer.parseInt(request.getParameter("changeQty"));
		String reason = request.getParameter("reason");
		String userName = request.getParameter("username");
		int invoiceId = Integer.parseInt(request.getParameter("invoiceId"));

		StockLog s = new StockLog();
		s.setProductId(productId);
		s.setChangeQuantity(changeQty);
		s.setReason(reason);
		s.setUserName(userName);
		s.setInvoiceId(invoiceId);

		StockLogDAO dao = new StockLogDAO();
		String status = dao.addLog(s);

		if (status.equals("success")) {
			System.out.println("Log added\n");
			response.sendRedirect("staff-dashboard.jsp");
		} else {
			System.out.println("something went wrong(stock log)\n");
			RequestDispatcher rd = request.getRequestDispatcher("staff-stock-log.jsp");
			rd.forward(request, response);
		}
	}

}

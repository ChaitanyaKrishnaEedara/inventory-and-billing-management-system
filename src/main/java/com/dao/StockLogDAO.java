package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.model.StockLog;
import com.utility.DBConnection;

public class StockLogDAO implements StockLogDAOInterface {

	Connection con = null;
	String status = "fail";

	@Override
	public String addLog(StockLog s) {
		try {
			DBConnection dbc = new DBConnection();
			con = dbc.getConnection();

			PreparedStatement ps = con.prepareStatement(
					"insert into stock_log(product_id, change_qty, reason, user_name, invoice_id) values(?,?,?,?,?)");
			ps.setInt(1, s.getProductId());
			ps.setInt(2, s.getChangeQuantity());
			ps.setString(3, s.getReason());
			ps.setString(4, s.getUserName());
			ps.setInt(5, s.getInvoiceId());

			int n = ps.executeUpdate();

			if (n > 0)
				status = "success";

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

}

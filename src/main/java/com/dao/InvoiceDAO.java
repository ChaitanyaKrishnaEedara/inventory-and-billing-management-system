package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Invoice;
import com.utility.DBConnection;

public class InvoiceDAO implements InvoiceDAOInterface {

	Connection con = null;
	String status = "fail";

	@Override
	public int createInvoice(Invoice i) {
		try {
			DBConnection dbc = new DBConnection();
			con = dbc.getConnection();

			PreparedStatement ps = con.prepareStatement(
					"insert into invoices(user_name, customer_name, customer_phone, customer_email, product_id, quantity, total_amount) values(?,?,?,?,?,?,?)");
			ps.setString(1, i.getUserName());
			ps.setString(2, i.getCustomerName());
			ps.setString(3, i.getCustomerPhone());
			ps.setString(4, i.getCustomerEmail());
			ps.setInt(5, i.getProductId());
			ps.setInt(6, i.getQuantity());
			ps.setBigDecimal(7, i.getTotalAmount());

			int n = ps.executeUpdate();

			if (n > 0) {
				PreparedStatement ps1 = con
						.prepareStatement("select invoice_id from invoices order by invoice_id desc limit 0,1");
				ResultSet rs = ps1.executeQuery();
				rs.next();
				return rs.getInt("invoice_id");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return -1;
	}

	@Override
	public List<Invoice> getInvoicesByUsername(String username) {
		List<Invoice> invoices = new ArrayList<Invoice>();
		try {
			DBConnection dbc = new DBConnection();
			con = dbc.getConnection();

			PreparedStatement ps = con.prepareStatement(
					"select invoices.*, products.name from invoices natural join products where user_name = ?");
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Invoice i = new Invoice();
				i.setInvoiceId(rs.getInt("invoice_id"));
				i.setUserName(rs.getString("user_name"));
				i.setCustomerName(rs.getString("customer_name"));
				i.setCustomerPhone(rs.getString("customer_phone"));
				i.setCustomerEmail(rs.getString("customer_email"));
				i.setProductId(rs.getInt("product_id"));
				i.setQuantity(rs.getInt("quantity"));
				i.setInvoiceDate(rs.getTimestamp("invoice_date"));
				i.setTotalAmount(rs.getBigDecimal("total_amount"));

				invoices.add(i);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return invoices;
	}

}

package com.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Product;
import com.utility.DBConnection;

public class ProductDAO implements ProductDAOInterface {

	String status = "fail";

	Connection con = null;

	@Override
	public List<Product> getAllProducts() {
		List<Product> list = new ArrayList<>();

		try {
			DBConnection dbc = new DBConnection();
			con = dbc.getConnection();

			PreparedStatement ps = con.prepareStatement("select * from products");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setProductId(rs.getInt("product_id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getBigDecimal("price"));
				p.setQuantityInStock(rs.getInt("quantity_in_stock"));
				p.setStatus(rs.getString("status"));

				list.add(p);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public List<Product> getAllActiveProducts() {
		List<Product> list = new ArrayList<>();

		try {
			DBConnection dbc = new DBConnection();
			con = dbc.getConnection();

			PreparedStatement ps = con.prepareStatement("select * from products where status='ACTIVE'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setProductId(rs.getInt("product_id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getBigDecimal("price"));
				p.setQuantityInStock(rs.getInt("quantity_in_stock"));
				p.setStatus(rs.getString("status"));

				list.add(p);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public BigDecimal getProductPrice(int productId) {
		BigDecimal price = null;
		try {
			DBConnection dbc = new DBConnection();
			con = dbc.getConnection();

			PreparedStatement ps = con.prepareStatement("select price from products where product_id = ?");
			ps.setInt(1, productId);

			ResultSet rs = ps.executeQuery();
			if (rs.next())
				price = rs.getBigDecimal("price");

		} catch (Exception e) {
			System.out.println(e);
		}

		return price;
	}

	@Override
	public String addProduct(Product p) {
		try {
			DBConnection dbc = new DBConnection();
			con = dbc.getConnection();

			PreparedStatement ps = con
					.prepareStatement("insert into products(name, price, quantity_in_stock) values(?, ?, ?)");
			ps.setString(1, p.getName());
			ps.setBigDecimal(2, p.getPrice());
			ps.setInt(3, p.getQuantityInStock());

			int n = ps.executeUpdate();

			if (n > 0)
				status = "success";

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Override
	public String updateProductQuantity(int productId, int quantity) {
		try {
			DBConnection dbc = new DBConnection();
			con = dbc.getConnection();

			PreparedStatement ps = con.prepareStatement(
					"update products set quantity_in_stock = quantity_in_stock - ? where product_id = ?");
			ps.setInt(1, quantity);
			ps.setInt(2, productId);

			int n = ps.executeUpdate();
			if (n > 0)
				status = "success";

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	@Override
	public String updateProduct(Product p) {
		try {
			DBConnection dbc = new DBConnection();
			con = dbc.getConnection();

			PreparedStatement ps = con
					.prepareStatement("update products set name = ?, price = ?, status = ? where product_id = ?");
			ps.setString(1, p.getName());
			ps.setBigDecimal(2, p.getPrice());
			ps.setString(3, p.getStatus());
			ps.setInt(4, p.getProductId());

			int n = ps.executeUpdate();
			if (n > 0)
				status = "success";

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

}

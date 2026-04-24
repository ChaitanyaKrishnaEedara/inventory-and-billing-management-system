package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.User;
import com.utility.DBConnection;

public class UserDAO implements UserDAOInterface {

	String status = "fail";

	Connection con = null;

	@Override
	public String addUser(User u) {
		try {
			DBConnection dbc = new DBConnection();
			con = dbc.getConnection();

			PreparedStatement ps = con
					.prepareStatement("insert into users(user_name, password, role_id) values(?, ?, ?)");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setInt(3, u.getRoleId());

			int n = ps.executeUpdate();

			if (n > 0)
				status = "success";

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Override
	public User login(String username, String password) {
		try {
			DBConnection dbc = new DBConnection();
			con = dbc.getConnection();

			PreparedStatement ps = con.prepareStatement(
					"select user_name, users.role_id, roles.role_name from users natural join roles where user_name = ? and password = ? and status = 'ACTIVE'");
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("user_name"));
				user.setRole(rs.getString("role_name"));
				return user;
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}
	
	@Override
	public User getUserDetails(String username) {
		try {
			DBConnection dbc = new DBConnection();
			con = dbc.getConnection();

			PreparedStatement ps = con.prepareStatement(
					"select users.*, roles.role_name from users natural join roles where user_name = ?");
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("user_name"));
				user.setRole(rs.getString("role_name"));
				return user;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> list = new ArrayList<>();

		try {
			DBConnection dbc = new DBConnection();
			con = dbc.getConnection();

			PreparedStatement ps = con.prepareStatement(
					"select user_name, password, users.role_id, roles.role_name, status from users natural join roles");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setUsername(rs.getString("user_name"));
				u.setPassword(rs.getString("password"));
				u.setRoleId(rs.getInt("role_id"));
				u.setRole(rs.getString("role_name"));
				u.setStatus(rs.getString("status"));
				
				list.add(u);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

}

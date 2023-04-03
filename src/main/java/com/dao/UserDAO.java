package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDAO {
	private Connection conn;

	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addUser(User u) {
		
		boolean f = false;
		try {
			
			String sql = "INSERT INTO USER(name,qualification,email,password,role) VALUES (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getQualification());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setString(5, "user");
			
			int i = ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public User login(String email, String password) {
		
		User u = null;
		
		try {
			
			String sql = "SELECT * FROM USER WHERE email = ? and password = ?";
			PreparedStatement ps1 = conn.prepareStatement(sql);
			ps1.setString(1, email);
			ps1.setString(2, password);
			
			ResultSet rs = ps1.executeQuery();
			while(rs.next()) {
				u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setQualification(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setPassword(rs.getString(5));
				u.setRole(rs.getString(6));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return u;
		
	}
	
	public boolean updateUser(User u) {
		boolean f = false;
		try {
			String sql = "UPDATE USER DET name=?, qualification=?, email=?, password=? where id = ?";
			PreparedStatement ps2 = conn.prepareStatement(sql);
			ps2.setString(1, u.getName());
			ps2.setString(2, u.getQualification());
			ps2.setString(3, u.getEmail());
			ps2.setString(4, u.getPassword());
			ps2.setInt(5, u.getId());
			
			int i = ps2.executeUpdate();
			if(i==1) {
				f=true;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}

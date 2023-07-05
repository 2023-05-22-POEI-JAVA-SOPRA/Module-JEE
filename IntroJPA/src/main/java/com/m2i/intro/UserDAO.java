package com.m2i.intro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UserDAO {

	
	
	public static List<User> getAllUser(){
		
		List<User> res = new ArrayList<>();
		
		try {
			Connection con = UtilConnexion.seConnecter();
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM user;");
			
			while ( rs.next() ) {				
				res.add(new User(
					rs.getInt("id"),
					rs.getString("email"),
					rs.getString("login"),
					rs.getString("password")
				));
				
			}
			
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static User getUserById(int id) {
		
		User u = null;
		try {
			Connection con = UtilConnexion.seConnecter();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE id=?;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if ( rs.next()) {	
				u = new User(
					rs.getInt("id"),
					rs.getString("email"),
					rs.getString("login"),
					rs.getString("password")						
				);
			}
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public static boolean deleteUserById(int id) {
		
		try {
			Connection con = UtilConnexion.seConnecter();
			
			PreparedStatement ps = con.prepareStatement("DELETE FROM user WHERE id=?;");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			con.close();
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean updateUser(int id, String email, String login, String password) {
		return updateUser( new User(id, email, login, password));
	}
	
	public static boolean updateUser(User u) {
		
		try {
			Connection con = UtilConnexion.seConnecter();
			
			PreparedStatement ps = con.prepareStatement("UPDATE user SET login=?, email=?, password=? WHERE id=?;");
			ps.setString(1, u.getLogin());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			ps.setInt(4, u.getId());
			
			ps.executeUpdate();
			
			con.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean createUser(String email, String login, String password) {
		return saveUser( new User(email, login, password));
	}
	
	public static boolean saveUser(User u) {
		
		try {
			Connection con = UtilConnexion.seConnecter();
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO user(login, email, password) VALUE( ?, ?, ?);");
			
			ps.setString(1, u.getLogin());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			
			ps.executeUpdate();
			
			con.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
}
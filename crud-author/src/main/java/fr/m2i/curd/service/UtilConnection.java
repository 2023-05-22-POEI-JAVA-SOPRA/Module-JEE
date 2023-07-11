package fr.m2i.curd.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class UtilConnection {

	
	public static Connection seConnecter() {
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdb", "root", "root");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
}

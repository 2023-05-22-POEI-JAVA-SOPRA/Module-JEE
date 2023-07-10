package fr.m2i.crud.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import fr.m2i.crud.entity.Product;

public class ProductService {

	
	public ArrayList<Product> getAll(){
		
		ArrayList<Product> products = new ArrayList<>();
		
		try {
			Connection con = UtilConnection.seConnecter();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Product");
			ResultSet rs = ps.executeQuery();
			while ( rs.next() ) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				float price = rs.getFloat("price");
				int quantity = rs.getInt("quantity");
				
				Product p = new Product(id, name, description, price, quantity);
				products.add(p); 
			}
			con.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return products;
	}
	
	public Product getById(int id) {
		try {
			Connection con = UtilConnection.seConnecter();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Product WHERE id = " + id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				float price = rs.getFloat("price");
				int quantity = rs.getInt("quantity");
				
				return new Product(id, name, description, price, quantity);
			} else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public boolean update(int id, Product p) {
		try {
			Connection con = UtilConnection.seConnecter();
			PreparedStatement ps = con.prepareStatement("UPDATE Product SET name =?, description = ?, price= ?, quantity = ? WHERE id = ?");
			
			ps.setString(1, p.getName());
			ps.setString(2, p.getDescription());
			ps.setFloat(3, p.getPrice());
			ps.setInt(4, p.getQuantity());

			ps.setInt(5, id);
			
			int result = ps.executeUpdate();
			
			if (result == 1) {
				return true;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public boolean update(int id, String name, String description, float price, int quantity) {
		return update(id, new Product(0, name, description, price, quantity));
	}
	
	
	public boolean create(Product p) {
		try {
			Connection con = UtilConnection.seConnecter();
			PreparedStatement ps = con.prepareStatement(
			"INSERT INTO Product (name, description, price, quantity) VALUES ('"+p.getName()+"', '"+p.getDescription()+"', "+p.getPrice()+", "+p.getQuantity()+");"	
			);
			int result = ps.executeUpdate();
			
			if (result == 1) {
				return true;
			}
			
		} catch (Exception e) {
			System.out.println("CREATE ERROR :" + e);
		}
		return false;
	}
	
	public boolean create(String name, String description, float price, int quantity) {
		return create(new Product(0, name, description, price, quantity));

	}
	
	
	public boolean delete(int id) {
		try {
			Connection con = UtilConnection.seConnecter();
			PreparedStatement ps = con.prepareStatement(
			"DELETE FROM Product WHERE id = "+ id +";"		
			);
			int result = ps.executeUpdate();
			
			if (result == 1) {
				return true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}

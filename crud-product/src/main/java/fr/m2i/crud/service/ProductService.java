package fr.m2i.crud.service;

import java.util.ArrayList;

import fr.m2i.crud.entity.Product;

public class ProductService {
	private ArrayList<Product> productList = new ArrayList<>();

	
	public ArrayList<Product> getAll(){
		return productList;
	}
	
	public Product getById(int id) {
		try {
			return productList.get(id);			
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public boolean update(int id, Product p) {
		try {
			productList.set(id, p);
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		} 
	}
	
	public boolean update(int id, String name, String description, float price, int quantity) {
		return update(id, new Product(name, description, price, quantity));
	}
	
	
	public void create(Product p) {
		productList.add(p);
	}
	
	public void create(String name, String description, float price, int quantity) {
		create(new Product(name, description, price, quantity));
	}
	
	
	public boolean delete(int id) {
		try {
			productList.remove(id);
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
		
	}
}

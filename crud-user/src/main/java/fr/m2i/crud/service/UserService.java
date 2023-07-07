package fr.m2i.crud.service;

import java.util.ArrayList;

import fr.m2i.crud.model.User;

public class UserService {

	ArrayList<User> listUsers = new ArrayList<>();
	
	
	public User getById(int id) {
		try {
			return listUsers.get(id);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public ArrayList<User> getAll(){
		return listUsers;
	}
	
	public boolean create(User u) {
		if (u == null) {
			return false;
		}
		
		listUsers.add(u);
		return true;
	}
	
	public boolean create(String name, String login, String password, String email, int age) {		
		User u = new User(name, login, password, email, age);
		return create(u);
	}
	
	public boolean update(int id, User u) {
		try {
			listUsers.set(id, u);
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}
	
	public boolean update(int id, String name, String login, String password, String email, int age) {
		User u = new User(name, login, password, email, age);
		return update(id, u);
	}
	
	
	public boolean delete(int id) {
		try {
			listUsers.remove(id);
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}
	
}

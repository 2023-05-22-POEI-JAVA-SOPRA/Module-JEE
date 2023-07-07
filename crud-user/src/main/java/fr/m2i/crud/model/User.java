package fr.m2i.crud.model;

public class User {
	String name;
	String login;
	String password;
	String email;
	int age;
	
	public User(String name, String login, String password, String email, int age) {
		super();
		this.name = name;
		this.login = login;
		this.password = password;
		this.email = email;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", login=" + login + ", password=" + password + ", email=" + email + ", age="
				+ age + "]";
	}
	
	
	
}

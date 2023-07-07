import com.google.gson.Gson;

import fr.m2i.crud.model.User;

public class Main {
	
	public static void main(String[] args) {

		Gson gson = new Gson();

		// From string  to object
		
		String userInJson = "{'name':'Toto','login':'login','password':'sueperPassword','email':'toto@gmail.com','age':28}";
		
		
		User u = gson.fromJson(userInJson, User.class);
		
		System.out.println(u);
		
		
		// From object to string
		
		
		User user = new User("name", "login", "password", "email@email.com", 28);
		
		String userToJson = gson.toJson(user);
		
		System.out.println(userToJson);

	}
	
}

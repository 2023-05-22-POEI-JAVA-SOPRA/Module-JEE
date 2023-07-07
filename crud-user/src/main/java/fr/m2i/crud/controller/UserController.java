package fr.m2i.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.m2i.crud.model.User;
import fr.m2i.crud.service.UserService;


@WebServlet("/User")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserService service = new UserService();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt( request.getParameter("id"));
			User u = service.getById(id);
			if (u != null) {
				response.getWriter().print(u);
			} else {
				response.getWriter().print("User not found");				
			}
		} catch (NumberFormatException e) {
			ArrayList<User> listUsers = service.getAll();
			PrintWriter out = response.getWriter();
			
			for (User user : listUsers) {
				out.println(user);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		int age = Integer.parseInt( request.getParameter("age") );
		
		if (service.create(name, login, password, email, age)) {
			response.getWriter().print("User Created");
		} else {
			response.getWriter().print("User not Created");			
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		int age = Integer.parseInt( request.getParameter("age") );
		
		int id = Integer.parseInt( request.getParameter("id") );
		
		if (service.update(id, name, login, password, email, age)) {
			response.getWriter().print("User Updated");
		} else {
			response.getWriter().print("User not Updated");
		}
	
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt( request.getParameter("id"));
		
		if (service.delete(id)) {
			response.getWriter().print("User Deleted");
		} else {
			response.getWriter().print("User not Deleted");
		}
	}

}

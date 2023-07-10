package fr.m2i.crud.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import com.google.gson.Gson;

import fr.m2i.crud.model.Score;
import fr.m2i.crud.model.User;
import fr.m2i.crud.service.UserService;


@WebServlet("/User")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserService service = new UserService();
	Gson gson = new Gson();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			int id = Integer.parseInt( request.getParameter("id"));
			User u = service.getById(id);
			if (u != null) {
				
				response.getWriter().print( gson.toJson(u));
			} else {
				response.getWriter().print("User not found");
				response.setStatus( Response.SC_FORBIDDEN);
			}
		} catch (NumberFormatException e) {
			ArrayList<User> listUsers = service.getAll();
			
			response.getWriter().print(gson.toJson(listUsers));			
		}
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader reader = request.getReader();
		User user = gson.fromJson(reader, User.class);
		
		if (service.create(user)) {
			response.getWriter().print("User Created");
			response.setStatus( Response.SC_CREATED );
		} else {
			response.getWriter().print("User not Created");
			response.setStatus( Response.SC_FORBIDDEN);
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BufferedReader reader = request.getReader();
		User user = gson.fromJson(reader, User.class);
		
		
		int id = Integer.parseInt( request.getParameter("id") );
		
		if (service.update(id, user)) {
			response.getWriter().print("User Updated");
		} else {
			response.getWriter().print("User not Updated");
			response.setStatus( Response.SC_FORBIDDEN);

		}
	
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt( request.getParameter("id"));
		
		if (service.delete(id)) {
			response.getWriter().print("User Deleted");
		} else {
			response.getWriter().print("User not Deleted");
			response.setStatus( Response.SC_FORBIDDEN);

		}
	}

}

package com.m2i.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.m2i.model.User;

	
	@WebServlet("/JsonServlet") 
	public class JsonServlet extends HttpServlet {
		User u = new User("Java", "java@exemple.com", "jee", 23);
		Gson gson = new Gson();
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.getWriter().append(gson.toJson(u));
		}
	}

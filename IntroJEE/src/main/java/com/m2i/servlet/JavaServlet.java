package com.m2i.servlet;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	
	@WebServlet("/JavaServlet")
	public class JavaServlet extends HttpServlet {
		
		int nombreAppel = 0;
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Date date = new Date();
			nombreAppel = nombreAppel + 1;
			
			response.getWriter()
				.append("You called this function at :")
				.append(date.toString())
				.append(" pour la " + nombreAppel + "eme fois");
		}
	}


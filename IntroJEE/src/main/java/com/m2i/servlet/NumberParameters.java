package com.m2i.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/NumberParameters")
public class NumberParameters extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, NumberFormatException {
		
		int birthDay = Integer.parseInt( request.getParameter("birthday")) - 2023; 
		response.getWriter().append("You're").append( Integer.toString(birthDay) );
	}

}




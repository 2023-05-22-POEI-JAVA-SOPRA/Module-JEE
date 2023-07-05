package com.m2i.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BodyParameters")
public class BodyParameters extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String body = request.getReader().lines()
				.reduce("", (accumulator, actual) -> accumulator + actual);
		
		response.getWriter().append("Body :").append(body);;
	}
}




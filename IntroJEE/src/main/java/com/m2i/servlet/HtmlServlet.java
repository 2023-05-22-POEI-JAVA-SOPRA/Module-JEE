package com.m2i.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HtmlServlet")
public class HtmlServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();

        String htmlRespone = "<html>";
        htmlRespone += "<h2>Welcome to my Hello world app</h2>";      
        htmlRespone += "<p>This is our first html response</p>";    
        htmlRespone += "</html>";
         
        // return response
        writer.println(htmlRespone);
	}
}

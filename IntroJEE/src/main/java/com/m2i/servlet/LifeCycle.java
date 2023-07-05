package com.m2i.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifeCycle")
public class LifeCycle extends HttpServlet {
	
    public LifeCycle() {
    	System.out.println("Constructor (1)");
    }

    @Override
    public void init() throws ServletException {
    	System.out.println("Init (2)");
    	super.init();

    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("DoGet (3)");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	public void destroy() {
    	System.out.println("Destroy (4)");

		super.destroy();
	}
}



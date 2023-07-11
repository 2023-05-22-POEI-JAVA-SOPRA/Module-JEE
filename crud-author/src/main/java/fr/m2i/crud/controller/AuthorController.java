package fr.m2i.crud.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fr.m2i.crud.model.Author;
import fr.m2i.curd.service.AuthorService;

@WebServlet("/AuthorController")
public class AuthorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AuthorService service = new AuthorService();
	
	
    public AuthorController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-mm-dd").create();
		
		try {
			
			int id = Integer.parseInt( request.getParameter("id") );
			Author author = service.getById(id);
			if (author != null) {
				response.getWriter().print( gson.toJson(author));
			} else {
				response.getWriter().print("Index not found");
			}
		} catch (Exception e) {
			ArrayList<Author> liste = service.getAll();
			response.getWriter().print(gson.toJson(liste) );
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BufferedReader reader = request.getReader();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-mm-dd").create();
		
		Author author = gson.fromJson(reader, Author.class);
	
		boolean created = service.create(author);
		
		if (created == true) {
			response.getWriter().print("Author Created");
		} else {
			response.getWriter().print("Author not Created");
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader reader = request.getReader();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-mm-dd").create();

		int id = Integer.parseInt( request.getParameter("id") );
		Author author = gson.fromJson(reader, Author.class);
	
		boolean updated = service.update(id, author);
		if (updated == true) {
			response.getWriter().print("Author Updated");
		} else {
			response.getWriter().print("Author not Updated");
		}
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt( request.getParameter("id") );

		boolean deleted = service.delete(id);
		if (deleted == true) {
			response.getWriter().print("Author Deleted");
		} else {
			response.getWriter().print("Author not Deleted");
		}
	}
	
}

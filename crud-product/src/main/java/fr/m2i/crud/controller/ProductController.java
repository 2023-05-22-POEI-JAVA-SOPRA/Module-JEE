package fr.m2i.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.m2i.crud.entity.Product;
import fr.m2i.crud.service.ProductService;

@WebServlet("/Product")
public class ProductController extends HttpServlet {

	ProductService service = new ProductService();

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int id = Integer.parseInt(request.getParameter("id"));

			Product p = service.getById(id);

			if (p != null) {
				response.getWriter().print(p);
			} else {
				response.getWriter().print("Index does not exists");
			}

		} catch (NumberFormatException e) {
			PrintWriter out = response.getWriter();
			for (Product product : service.getAll()) {
				out.println(product);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		float price = Float.parseFloat(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		service.create(name, description, price, quantity);
		response.getWriter().append("Product created succesfuly");

	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		if (service.delete(id)) {
			response.getWriter().print("Product deleted");
		} else {
			response.getWriter().print("Product not found");
		}
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		float price = Float.parseFloat(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		int id = Integer.parseInt(request.getParameter("id"));

		if (service.update(id, name, description, price, quantity)) {
			response.getWriter().append("Product updated");
		} else {
			response.getWriter().print("Product not found");
		}
	}


}

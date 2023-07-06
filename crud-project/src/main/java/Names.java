

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Names")
public class Names extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArrayList<String> names = new ArrayList<>();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		
		
		for (String name : names) {
			out.println(name);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");		
		if (name != null) {
			names.add(name);			
		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt( request.getParameter("id") );
		
		if (id < names.size()) {
			String removedName = names.get(id);
			names.remove(id);
			response.getWriter().append(removedName + " have been removed");
		} else {
			response.getWriter().append("index does not exists");
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt( request.getParameter("id") );
		String name = request.getParameter("name");		

		if (id < names.size()) {
			String updatedName = names.get(id);
			names.set(id, name);
			response.getWriter().append( updatedName + " have benn updated to " + name);
		} else {
			response.getWriter().append("index does not exists");
		}
	}
}

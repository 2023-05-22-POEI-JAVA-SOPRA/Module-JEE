

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession(true);
		session.setAttribute("login", login);
		session.setAttribute("password", password);
		
		
		System.out.println("in doGet");
		request.getRequestDispatcher("/Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in do post");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		if ("jee".equals(login) && "java".equals(password)) {
			request.getSession(true).setAttribute("is_logged", true);
			request.getRequestDispatcher("/Connected.jsp").forward(request, response);
		} else {
			doGet(request,response);
			request.getSession(true).setAttribute("is_logged", false);

		}
	}

}

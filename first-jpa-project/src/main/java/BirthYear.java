

import java.io.IOException;
import java.time.LocalDateTime;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BirthYear")
public class BirthYear extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		response.getWriter()
		.append("<!DOCTYPE html>")
		.append("<html>")
		.append("	<body>")
		.append("		<form method='post'>")
		.append("			<input name='age' type='number'>")
		.append("			<input type='submit'>")
		.append("		</form>")
		.append("	</body>")
		.append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String age = request.getParameter("age");
		int age_integer = Integer.parseInt(age);
		int birthyear = LocalDateTime.now().getYear() - age_integer;
		
		response.getWriter().append("Your birth year is " + birthyear);
		
	}

}

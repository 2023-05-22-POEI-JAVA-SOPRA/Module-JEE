

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String error = (String) request.getAttribute("error");
		
		System.out.println("In do Get");
		
		response.getWriter()
        .append("<!DOCTYPE html>")
        .append("<html>")
        .append("	<head>")
        .append("		<title>Test titre</title>")
        .append("	</head>")
        .append("	<body>")
        .append("	<h1>Login</h1>")
		.append("	<a href='/first-jpa-project/HelloYou?name=Toto'>To Hello</a>");
		
		if (error != null) {
			response.getWriter().append("<h4>"+ error +"</h4>");
		}
		response.getWriter()
        .append("	<form method='post' >")
        .append("		<input name='tbLogin' type='text'/>")
        .append("		<br/>")
        .append("		<input name='tbPass' type='password'/>")
        .append("		<br/>")
        .append("		<input name='bValider' type='submit' value='Valider'>")
        .append("	</form>")        
        .append("	</body>")
        .append("</html>");
	}
	
	// POST http://localhost:8080/first-jpa-project/login?tbLogin=''&tbPass=''

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("tbLogin");
		String password = request.getParameter("tbPass");
				
		if ("jee".equals(login) && "java".equals(password)) {
			response.getWriter().append("You're logged");
		} else {
			request.setAttribute("error", "bad credentials");
			doGet(request,response);
		}
		
	}

}

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		response.getWriter()
		.append("<!DOCTYPE html>")
		.append("<html>")
		.append("    <head>")
		.append("        <title>First java servlet</title>")
		.append("    </head>")
		.append("    <body>")
		.append("    	<h1> Hello from java </h1>")
		.append("    	<h2>"+ new Date() +"</h2>")
		.append("    </body>")
		.append("</html>");
	}
}

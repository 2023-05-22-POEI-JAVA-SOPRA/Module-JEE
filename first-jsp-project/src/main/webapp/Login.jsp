<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Hello world</h1>
		
		<h4> <%= new Date() %>  </h4>
		
		<%for (int i = 1; i <= 6; i++){%>
			<h<%= i %>> Titre de niveau <%= i %></h<%= i %>>
		<%}%>
		
		<%
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		if (request.getMethod().equals("POST") && "jee".equals(login) && "java".equals(password)){
		%>
			<h1> Your logged</h1>
		<%} else { %>
			<form method="post">
				<input name='login' type='text'/> <br>
				<input name='password' type='password'/> <br>
				<input type='submit' value="Valider"/> <br>
			</form>
		<% } %>
		
		<h1><%= request.getMethod() %></h1>
	</body>
</html>
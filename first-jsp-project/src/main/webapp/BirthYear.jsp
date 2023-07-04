<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.LocalDateTime" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
	
		<%
		if (request.getMethod().equals("POST")){	
			String age = request.getParameter("age");
			int age_integer = Integer.parseInt(age);
			int birthyear = LocalDateTime.now().getYear() - age_integer;
		%>
				<h1>Your birth year is <%= birthyear %></h1>
		
		<%
		} else {
		%>
		
		<h1>Calculate your age</h1>
		
		<form method='post'>
			<input name='age' type='number'>
			<br>
			<input type='submit'>
		</form>
		
		<%
		}
		%>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Hello from jsp</h1>
		
		<h2><%= session.getAttribute("name")%></h2>
		
		<h2>${name}</h2>
		
		<input>
		
		<form method="get" action="/first-jpa-project/Exemple">
			
			<h1>Form</h1>
			<input name="name" type="text">
			<input type=submit>
		</form>
		
	</body>
</html>
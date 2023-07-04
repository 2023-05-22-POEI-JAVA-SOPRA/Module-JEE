<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
	</head>
	<body>
		<h1>Login</h1>
		
		<form method="post">
			<input name='login' type='text' value="${login}"/> <br>
			<input name='password' type='password' value="<%= session.getAttribute("password") %>"/> <br>
			<input type='submit' value="Valider"/> <br>
		</form>
		
	</body>
</html>
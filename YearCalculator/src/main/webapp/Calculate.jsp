<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<form method="post">
			<h1>My birth day</h1>
			<input name="birthDay" type="number">
			<input name="birthMonth" type="number">
			<input name="birthYear" type="number">
		
			<h1>Current date</h1>
			<input name="currentDay" type="number" value="${day}">
			<input name="currentMonth" type="number" value="${month}">
			<input name="currentYear" type="number" value="${year}">
			
			<br>
			<br>
			<input type="submit">
			
		</form>
		
	</body>
</html>
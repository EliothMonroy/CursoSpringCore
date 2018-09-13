<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hola Mundo - Spring MVC</title>
</head>
<body>
	<h1>Registered Person !!</h1>
	<h2>${personCreated} was created at: ${servertime}</h2>

	<a href="${pageContext.request.contextPath}/person">Go back</a>
</body>
</html>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejemplo</title>
</head>
<body>
	<%
	for (int i = 1; i <= 3; i++) {
	%>
	<h1>
		Ejemplo de JSP:
		<%=LocalDateTime.now()%></h1>
	<%
	}
	%>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String nombre = request.getParameter("nombre");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Saludo</title>
</head>
<body>
	<form action="saludo.jsp" method="post">
		<input name="nombre" placeholder="Introduce tu nombre">
		<button>Saludar</button>
		<span>Hola <%= nombre %></span>
	</form>
</body>
</html>
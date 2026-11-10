<%@page import="java.math.BigDecimal"%>
<%@page import="com.ipartek.formacion.amazonia.entidades.Producto"%>
<%@page import="com.ipartek.formacion.amazonia.accesodatos.DaoProducto"%>
<%@page import="java.math.BigDecimal"%>
<%@page
	import="com.ipartek.formacion.amazonia.accesodatos.impl.DaoProductoArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
DaoProducto dao = new DaoProductoArrayList();

dao.insertar(new Producto(1L, "Prueba", new BigDecimal("1234")));
dao.insertar(new Producto(2L, "Prueba2", new BigDecimal("21234")));

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de productos</title>
</head>
<body>

	<ul>
		<%
		for (Producto producto : dao.obtenerTodos()) {
		%>
		<li><%= producto.getNombre() %>: <%= producto.getPrecio() %>€</li>
		<%
		}
		%>
	</ul>

</body>
</html>
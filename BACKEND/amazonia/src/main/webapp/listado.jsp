<%@page import="com.ipartek.formacion.amazonia.accesodatos.impl.DaoProductoSqlite"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.ipartek.formacion.amazonia.entidades.Producto"%>
<%@page import="com.ipartek.formacion.amazonia.accesodatos.DaoProducto"%>
<%@page import="java.math.BigDecimal"%>
<%@page
	import="com.ipartek.formacion.amazonia.accesodatos.impl.DaoProductoArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
DaoProducto dao = new DaoProductoSqlite();

dao.insertar(new Producto(1L, "Prueba", new BigDecimal("1234")));
dao.insertar(new Producto(2L, "Prueba2", new BigDecimal("21234")));
%>
<!doctype html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Listado de productos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Amazonia</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				</ul>
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search" />
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</div>
		</div>
	</nav>

	<div class="row row-cols-1 row-cols-md-3 g-4">
		<%
		for (Producto producto : dao.obtenerTodos()) {
		%>
		<div class="col">
			<div class="card h-100">
				<img src="https://picsum.photos/400/300?<%=producto.getId() %>" class="card-img-top"
					alt="...">
				<div class="card-body">
					<h5 class="card-title"><%=producto.getNombre()%></h5>
					<p class="card-text"></p>
				</div>
				<div class="card-footer">
					<small class="text-body-secondary"><%=producto.getPrecio()%>€</small>
				</div>
			</div>
		</div>
		<%
		}
		%>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
		crossorigin="anonymous"></script>
</body>
</html>

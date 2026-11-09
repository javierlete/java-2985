package com.ipartek.formacion.ejemplos.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ejemplo")
public class EjemploServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); // application/json
		response.setCharacterEncoding("UTF-8");
		
		String nombre = request.getParameter("nombre");
		
		PrintWriter out = response.getWriter();
		
		out.printf("""
				<!DOCTYPE html>
				<html>
				<head>
					<title>Ejemplo</title>
				</head>
				<body>
					<h1>Hola %s</h1>
				</body>
				</html>
				""", nombre);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

package com.ipartek.formacion.iparrest.servlets.rest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/v1/platos/*")
public class PlatoRestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("""
			[
				{ "id": 1, "nombre": "Alubias", "precio": 8.0 },
				{ "id": 2, "nombre": "Filete", "precio": 9.0 }
			]
				""");
	}

}

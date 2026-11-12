package com.ipartek.formacion.iparrest.servlets.rest;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.ipartek.formacion.iparrest.accesodatos.PlatoDao;
import com.ipartek.formacion.iparrest.entidades.Plato;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/v1/platos/*")
public class PlatoRestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Gson GSON = new Gson();

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR AL CARGAR EL DRIVER DE SQLITE");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		String path = request.getPathInfo();

		System.out.println(path);

		if (path != null && path.length() > 1) {
			System.out.println("ID");

			Long id = Long.parseLong(path.substring(1));

			System.out.println(id);

			Plato plato = PlatoDao.obtenerPorId(id);
			String json = GSON.toJson(plato);
			
			response.getWriter().append(json);
		} else {
			ArrayList<Plato> platos = PlatoDao.obtenerTodos();
			String json = GSON.toJson(platos);
			
			response.getWriter().append(json);
		}
	}

	

}

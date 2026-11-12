package com.ipartek.formacion.iparrest.servlets.rest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;
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

			Plato plato = obtenerPorId(id);
			String json = GSON.toJson(plato);
			
			response.getWriter().append(json);
		} else {
			ArrayList<Plato> platos = obtenerTodos();
			String json = GSON.toJson(platos);
			
			response.getWriter().append(json);
		}
	}

	private ArrayList<Plato> obtenerTodos() {
		try {
			Connection con = DriverManager.getConnection("jdbc:sqlite:iparrest.db");
			PreparedStatement pst = con.prepareStatement("SELECT * FROM platos");
			ResultSet rs = pst.executeQuery();

			ArrayList<Plato> platos = new ArrayList<>();

			while (rs.next()) {
				Plato plato = new Plato(rs.getLong("id"), rs.getString("nombre"), rs.getBigDecimal("precio"), null);

				platos.add(plato);
			}

			return platos;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	private Plato obtenerPorId(Long id) {
		try {
			Connection con = DriverManager.getConnection("jdbc:sqlite:iparrest.db");
			PreparedStatement pst = con.prepareStatement("SELECT * FROM platos WHERE id=?");

			pst.setLong(1, id);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return new Plato(rs.getLong("id"), rs.getString("nombre"), rs.getBigDecimal("precio"),
						rs.getString("descripcion"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

}

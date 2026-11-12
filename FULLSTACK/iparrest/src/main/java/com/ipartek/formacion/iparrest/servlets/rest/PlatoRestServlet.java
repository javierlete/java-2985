package com.ipartek.formacion.iparrest.servlets.rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/v1/platos/*")
public class PlatoRestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

			try {
				Connection con = DriverManager.getConnection("jdbc:sqlite:iparrest.db");
				PreparedStatement pst = con.prepareStatement("SELECT * FROM platos WHERE id=?");
				
				pst.setLong(1, id);
				
				ResultSet rs = pst.executeQuery();
				PrintWriter out = response.getWriter();

				if (rs.next()) {
					out.append(String.format("""
							{ "id": %s, "nombre": "%s", "precio": %s, "descripcion": "%s" }""", rs.getLong("id"), rs.getString("nombre"),
							rs.getBigDecimal("precio"), rs.getString("descripcion")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			try {
				Connection con = DriverManager.getConnection("jdbc:sqlite:iparrest.db");
				PreparedStatement pst = con.prepareStatement("SELECT * FROM platos");
				ResultSet rs = pst.executeQuery();
				PrintWriter out = response.getWriter();

				StringBuffer sb = new StringBuffer();

				while (rs.next()) {
					sb.append(String.format("""
							{ "id": %s, "nombre": "%s", "precio": %s },""", rs.getLong("id"), rs.getString("nombre"),
							rs.getBigDecimal("precio")));
				}

				out.append("[");
				out.append(sb.substring(0, sb.length() - 1));
				out.append("]");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");

		try {
			Class.forName("org.sqlite.JDBC");

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
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

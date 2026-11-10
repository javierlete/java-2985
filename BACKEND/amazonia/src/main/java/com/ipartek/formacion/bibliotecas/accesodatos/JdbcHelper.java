package com.ipartek.formacion.bibliotecas.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcHelper {
	private final String jdbc, user, pass;
	
	public JdbcHelper(String driver, String jdbc, String user, String pass) {
		this.jdbc = jdbc;
		this.user = user;
		this.pass = pass;
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha podido cargar el driver " + driver, e);
		}
	}
	
	public PreparedStatement crearSentencia(String sql) throws SQLException {
		try {
			Connection con = DriverManager.getConnection(jdbc, user, pass);
			return con.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println("No se ha podido conectar a la base de datos");
			throw e;
		}
	}
}

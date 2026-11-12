package com.ipartek.formacion.iparrest.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.iparrest.entidades.Plato;

public class PlatoDao {
	public static ArrayList<Plato> obtenerTodos() {
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

	public static Plato obtenerPorId(Long id) {
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

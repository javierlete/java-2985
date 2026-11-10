package com.ipartek.formacion.amazonia.accesodatos.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.amazonia.accesodatos.DaoProducto;
import com.ipartek.formacion.amazonia.entidades.Producto;
import com.ipartek.formacion.bibliotecas.accesodatos.AccesoDatosException;
import com.ipartek.formacion.bibliotecas.accesodatos.JdbcHelper;

public class DaoProductoSqlite implements DaoProducto {
	private JdbcHelper jdbc = new JdbcHelper("org.sqlite.JDBC", "jdbc:sqlite:amazonia.db", "", "");

	@Override
	public Iterable<Producto> obtenerTodos() {
		try (PreparedStatement pst = jdbc.crearSentencia("SELECT * FROM productos");
				ResultSet rs = pst.executeQuery()) {
			ArrayList<Producto> productos = new ArrayList<>();

			while (rs.next()) {
				Producto producto = new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getBigDecimal("precio"));

				productos.add(producto);
			}

			return productos;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener los productos", e);
		}
	}

	@Override
	public Producto insertar(Producto producto) {
		try (PreparedStatement pst = jdbc.crearSentencia("INSERT INTO productos (nombre, precio) VALUES (?, ?)")) {
			pst.setString(1, producto.getNombre());
			pst.setBigDecimal(2, producto.getPrecio());

			pst.executeUpdate();

			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido insertar el producto " + producto, e);
		}
	}
}

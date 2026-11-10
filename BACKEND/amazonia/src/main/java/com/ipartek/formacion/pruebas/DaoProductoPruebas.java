package com.ipartek.formacion.pruebas;

import java.math.BigDecimal;

import com.ipartek.formacion.amazonia.accesodatos.DaoProducto;
import com.ipartek.formacion.amazonia.accesodatos.impl.DaoProductoArrayList;
import com.ipartek.formacion.amazonia.entidades.Producto;

public class DaoProductoPruebas {
	public static void main(String[] args) {
		DaoProducto dao = new DaoProductoArrayList();

		dao.insertar(new Producto(1L, "Prueba", new BigDecimal("1234")));
		dao.insertar(new Producto(2L, "Prueba2", new BigDecimal("21234")));

		for (Producto producto : dao.obtenerTodos()) {
			System.out.println(producto);
		}
	}
}

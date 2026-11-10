package com.ipartek.formacion.amazonia.accesodatos.impl;

import java.util.ArrayList;

import com.ipartek.formacion.amazonia.accesodatos.DaoProducto;
import com.ipartek.formacion.amazonia.entidades.Producto;

public class DaoProductoArrayList implements DaoProducto {
	private ArrayList<Producto> productos = new ArrayList<>();

	@Override
	public Iterable<Producto> obtenerTodos() {
		return productos;
	}

	@Override
	public Producto insertar(Producto producto) {
		productos.add(producto);
		
		return producto;
	}
}

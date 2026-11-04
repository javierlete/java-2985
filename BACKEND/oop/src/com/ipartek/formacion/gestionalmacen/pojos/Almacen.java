package com.ipartek.formacion.gestionalmacen.pojos;

import java.util.ArrayList;

public class Almacen {
	// VARIABLES DE INSTANCIA
	private String nombre;
	private ArrayList<Producto> productos = new ArrayList<>();
	
	// CONSTRUCTORES
	public Almacen(String nombre) {
		this.setNombre(nombre);
	}

	// GETTERS Y SETTERS	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// MÉTODOS DE INSTANCIA
	public void guardarProducto(Producto producto) {
		if (producto == null) {
			throw new IllegalArgumentException("No se admiten productos nulos");
		}
		
		productos.add(producto);
	}
	
	public ArrayList<Producto> listadoProductos() {
		return productos;
	}
	
	public int numeroProductos() {
		return productos.size();
	}
}

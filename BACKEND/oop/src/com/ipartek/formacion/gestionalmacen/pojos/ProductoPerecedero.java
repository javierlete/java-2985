package com.ipartek.formacion.gestionalmacen.pojos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductoPerecedero extends Producto {
	private LocalDate fechaCaducidad;

	public ProductoPerecedero(Long id, String nombre, BigDecimal precio, LocalDate fechaCaducidad) {
		super(id, nombre, precio);
		setFechaCaducidad(fechaCaducidad);
	}
	
	public ProductoPerecedero(String nombre, BigDecimal precio, LocalDate fechaCaducidad) {
		this(null, nombre, precio, fechaCaducidad);
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	@Override
	public String toString() {
		return String.format("ProductoPerecedero [id=%s, nombre=%s, precio=%s, fechaCaducidad=%s]", id,
				nombre, precio, fechaCaducidad);
	}
	
	
}

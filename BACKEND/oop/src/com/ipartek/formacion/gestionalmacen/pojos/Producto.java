package com.ipartek.formacion.gestionalmacen.pojos;

import java.math.BigDecimal;
import java.util.Objects;

public class Producto {
	// CONSTANTES
	private static final String SIN_NOMBRE = "SIN NOMBRE";
	public static final BigDecimal IVA_PORCENTAJE = new BigDecimal("0.21");

	// VARIABLES DE INSTANCIA
	protected Long id;
	protected String nombre;
	protected BigDecimal precio;

	// CONSTRUCTORES
	public Producto(Long id, String nombre, BigDecimal precio) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
	}

	public Producto(Long id, BigDecimal precio, String nombre) {
		this(id, nombre, precio);
	}

	public Producto(String nombre, BigDecimal precio) {
		this(null, nombre, precio);
	}

	public Producto() {
		this(null, SIN_NOMBRE, null);
	}

	// GETTERS Y SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.isBlank()) {
			throw new IllegalArgumentException("No se admiten nombres vacíos");
		}

		this.nombre = nombre.trim();
	}

	public String getNombre() {
		return nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public BigDecimal getIva() {
		return precio.multiply(IVA_PORCENTAJE);
	}

	// MÉTODOS DE INSTANCIA
	public void cambiarPrecio(BigDecimal tantoPorCien) {
		precio = precio.multiply(tantoPorCien.divide(new BigDecimal(100)).add(BigDecimal.ONE));
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(precio, other.precio);
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
	}

}

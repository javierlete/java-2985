package com.ipartek.formacion.gestionalmacen.pojos;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Empleado extends Persona {
	private String dni;
	private String nss;

	public Empleado(Long id, String nombre, String dni, String nss) {
		super(id, nombre);
		this.dni = dni;
		this.nss = nss;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}
	
	public abstract BigDecimal getSueldoMensual();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dni, nss);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(nss, other.nss);
	}

	@Override
	public String toString() {
		return String.format("Empleado [dni=%s, nss=%s]", dni, nss);
	}

}

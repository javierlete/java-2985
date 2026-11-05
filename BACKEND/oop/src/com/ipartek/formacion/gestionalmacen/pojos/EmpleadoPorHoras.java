package com.ipartek.formacion.gestionalmacen.pojos;

import java.math.BigDecimal;
import java.util.Objects;

public class EmpleadoPorHoras extends Empleado {
	private Integer numeroHoras;
	private BigDecimal sueldoPorHora;

	public EmpleadoPorHoras(Long id, String nombre, String dni, String nss, Integer numeroHoras,
			BigDecimal sueldoPorHora) {
		super(id, nombre, dni, nss);
		this.numeroHoras = numeroHoras;
		this.sueldoPorHora = sueldoPorHora;
	}

	public Integer getNumeroHoras() {
		return numeroHoras;
	}

	public void setNumeroHoras(Integer numeroHoras) {
		this.numeroHoras = numeroHoras;
	}

	public BigDecimal getSueldoPorHora() {
		return sueldoPorHora;
	}

	public void setSueldoPorHora(BigDecimal sueldoPorHora) {
		this.sueldoPorHora = sueldoPorHora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(numeroHoras, sueldoPorHora);
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
		EmpleadoPorHoras other = (EmpleadoPorHoras) obj;
		return Objects.equals(numeroHoras, other.numeroHoras) && Objects.equals(sueldoPorHora, other.sueldoPorHora);
	}

	@Override
	public String toString() {
		return String.format("EmpleadoPorHoras [numeroHoras=%s, sueldoPorHora=%s]", numeroHoras, sueldoPorHora);
	}

	@Override
	public BigDecimal getSueldoMensual() {
		return sueldoPorHora.multiply(new BigDecimal(numeroHoras));
	}

}

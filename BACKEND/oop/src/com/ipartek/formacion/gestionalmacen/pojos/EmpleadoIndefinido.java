package com.ipartek.formacion.gestionalmacen.pojos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class EmpleadoIndefinido extends Empleado {
	private Integer numeroPagas;
	private BigDecimal sueldoAnual;
	
	public EmpleadoIndefinido(Long id, String nombre, String dni, String nss, Integer numeroPagas,
			BigDecimal sueldoAnual) {
		super(id, nombre, dni, nss);
		this.numeroPagas = numeroPagas;
		this.sueldoAnual = sueldoAnual;
	}

	public Integer getNumeroPagas() {
		return numeroPagas;
	}

	public void setNumeroPagas(Integer numeroPagas) {
		this.numeroPagas = numeroPagas;
	}

	public BigDecimal getSueldoAnual() {
		return sueldoAnual;
	}

	public void setSueldoAnual(BigDecimal sueldoAnual) {
		this.sueldoAnual = sueldoAnual;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(numeroPagas, sueldoAnual);
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
		EmpleadoIndefinido other = (EmpleadoIndefinido) obj;
		return Objects.equals(numeroPagas, other.numeroPagas) && Objects.equals(sueldoAnual, other.sueldoAnual);
	}

	@Override
	public String toString() {
		return String.format("EmpleadoIndefinido [numeroPagas=%s, sueldoAnual=%s]", numeroPagas, sueldoAnual);
	}

	@Override
	public BigDecimal getSueldoMensual() {
		return sueldoAnual.divide(new BigDecimal(numeroPagas), 2, RoundingMode.HALF_UP);
	}
	
	
}

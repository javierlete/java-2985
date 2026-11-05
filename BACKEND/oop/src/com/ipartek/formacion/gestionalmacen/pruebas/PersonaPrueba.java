package com.ipartek.formacion.gestionalmacen.pruebas;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.ipartek.formacion.gestionalmacen.pojos.Empleado;
import com.ipartek.formacion.gestionalmacen.pojos.EmpleadoIndefinido;
import com.ipartek.formacion.gestionalmacen.pojos.EmpleadoPorHoras;

public class PersonaPrueba {
	public static void main(String[] args) {
		ArrayList<Empleado> empleados = new ArrayList<>();

		empleados.add(
				new EmpleadoIndefinido(null, "Javier", "12345678Z", "1234123412341234", 14, new BigDecimal("23456")));
		empleados.add(new EmpleadoPorHoras(null, "Pepe", "87654321Z", "4321432143214321", 80, new BigDecimal("23")));

		BigDecimal total = BigDecimal.ZERO;
		
		for(Empleado empleado: empleados) {
			System.out.println(empleado.getSueldoMensual());
			total = total.add(empleado.getSueldoMensual());
		}
		
		System.out.println(total);
	}
}

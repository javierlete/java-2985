package com.ipartek.formacion.gestionalmacen.pruebas;

import java.util.function.BiFunction;

public class Calculadora {
	public static void main(String[] args) {
		Operacion operacion;
		
		operacion = new Sumar();
		
		System.out.println(operacion.operar(5, 6));
		
		operacion = new Restar();

		System.out.println(operacion.operar(5, 6));
		
		operacion = new Operacion() {
			@Override
			public int operar(int a, int b) {
				return a * b;
			}
		};

		System.out.println(operacion.operar(5, 6));
		
		operacion = (a, b) -> a / b;
		
		System.out.println(operacion.operar(5, 6));
		
		BiFunction<Double, Double, Double> operacion2;
		
		operacion2 = (a, b) -> Math.pow(a, b);
		
		System.out.println(operacion2.apply(2.0, 3.0));
	}
	
	static class Restar implements Operacion {

		@Override
		public int operar(int a, int b) {
			return a - b;
		}
		
	}
}

interface Operacion {
	int operar(int a, int b);
}

class Sumar implements Operacion {

	@Override
	public int operar(int a, int b) {
		return a + b;
	}

}
package com.ipartek.formacion.gestionalmacen.pruebas;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.formacion.gestionalmacen.pojos.Producto;
import com.ipartek.formacion.gestionalmacen.pojos.ProductoPerecedero;

public class ProductoPerecederoPrueba {
	public static void main(String[] args) {
		ProductoPerecedero pp = new ProductoPerecedero("Cacahuetes", BigDecimal.TEN, LocalDate.now().plusMonths(6));

		System.out.println(pp);

		pp.setNombre("Prueba");
		pp.setPrecio(new BigDecimal("12345"));
		pp.setFechaCaducidad(LocalDate.now().plusMonths(2));

		System.out.println(pp);
		System.out.println(pp.getFechaCaducidad());

		Producto p = pp;

		System.out.println(p);

		// System.out.println(p.getFechaCaducidad()); // No se puede acceder desde el
		// tipo Producto

//		if (p instanceof ProductoPerecedero) {
//			ProductoPerecedero pp2 = (ProductoPerecedero) p;
		
		if (p instanceof ProductoPerecedero pp2) {
			System.out.println(pp2.getFechaCaducidad());

			System.out.println(pp2);

			Object o = pp2;

			System.out.println(o);
		} else {
			System.out.println("NO es un producto perecedero");
		}

		Object o2 = new Object();

		if (o2 instanceof ProductoPerecedero pp3) {
			System.out.println(pp3);
		} else {
			System.out.println("NO es un producto perecedero");
		}
	}
}

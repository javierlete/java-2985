package com.ipartek.formacion.gestionalmacen.pruebas;

import java.math.BigDecimal;

import com.ipartek.formacion.gestionalmacen.pojos.Almacen;
import com.ipartek.formacion.gestionalmacen.pojos.Producto;

public class AlmacenPrueba {
	public static void main(String[] args) {
		Almacen a = new Almacen("Bilbao");

		a.guardarProducto(new Producto("Portátil", new BigDecimal("1234.56")));
		a.guardarProducto(new Producto("Teclado", new BigDecimal("123.56")));
		a.guardarProducto(new Producto("Ratón", new BigDecimal("12.56")));

		for (Producto p : a.listadoProductos()) {
			System.out.println(p);
		}
		
		System.out.println("Hay " + a.numeroProductos() + " productos");
	}
}

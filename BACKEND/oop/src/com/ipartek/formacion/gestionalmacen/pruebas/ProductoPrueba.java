package com.ipartek.formacion.gestionalmacen.pruebas;

import java.math.BigDecimal;

import com.ipartek.formacion.gestionalmacen.pojos.Producto;

public class ProductoPrueba {
	public static void main(String[] args) {
		Producto p1 = null, p2;
	
		IO.println(p1);
		
		System.out.println();
		
		p1 = new Producto();
		p2 = new Producto();
		
		p1.setNombre("  prueba ");
		p1.setPrecio(new BigDecimal("1234.12"));
		
		IO.println(p1.getNombre());
		IO.println(p1.getPrecio());
		IO.println(p1.getIva());
		IO.println(Producto.IVA_PORCENTAJE);
		
		p2 = new Producto(2L, " Prueba   ", new BigDecimal("123.45"));
		
		IO.println(p2.getId());
		IO.println(p2.getNombre());
		IO.println(p2.getPrecio());
		
		p2.cambiarPrecio(new BigDecimal(5));
		IO.println(p2.getPrecio());
		
		Producto p3 = new Producto("PRODUCTO", BigDecimal.ZERO);
		Producto p4 = new Producto("PRODUCTO", BigDecimal.ZERO);
		
		IO.println(p3.getNombre());
		IO.println(p4.getNombre());
		
		IO.println(p3 == p4);
		IO.println(p3.equals(p4));
		
		IO.println(p3);
		IO.println(p4);
	}
}

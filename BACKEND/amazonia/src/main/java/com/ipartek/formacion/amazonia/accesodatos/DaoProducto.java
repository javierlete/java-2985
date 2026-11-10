package com.ipartek.formacion.amazonia.accesodatos;

import com.ipartek.formacion.amazonia.entidades.Producto;
import com.ipartek.formacion.bibliotecas.accesodatos.AccesoDatosException;
import com.ipartek.formacion.bibliotecas.accesodatos.Dao;

public interface DaoProducto extends Dao<Producto> {
	default Iterable<Producto> buscarPorNombre(String nombre) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
}

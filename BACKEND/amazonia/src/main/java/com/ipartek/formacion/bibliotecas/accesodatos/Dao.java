package com.ipartek.formacion.bibliotecas.accesodatos;

import java.util.Optional;

// Data Access Object
public interface Dao<T> {
	default Iterable<T> obtenerTodos() {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	default Optional<T> obtenerPorId(Long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	default T insertar(T objeto) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	default T modificar(T objeto) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	default void borrar(Long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
}

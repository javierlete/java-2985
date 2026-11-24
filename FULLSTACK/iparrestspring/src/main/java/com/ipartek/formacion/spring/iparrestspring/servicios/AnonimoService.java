package com.ipartek.formacion.spring.iparrestspring.servicios;

import java.util.Optional;

import com.ipartek.formacion.spring.iparrestspring.entidades.Plato;

public interface AnonimoService {
	Iterable<Plato> listadoPlatos();

	Optional<Plato> platoPorId(Long id);
}

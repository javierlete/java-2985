package com.ipartek.formacion.spring.iparrestspring.servicios;

import com.ipartek.formacion.spring.iparrestspring.entidades.Plato;

public interface AdminService {

	Plato crearPlato(Plato plato);

	void borrarPlato(Long id);

}

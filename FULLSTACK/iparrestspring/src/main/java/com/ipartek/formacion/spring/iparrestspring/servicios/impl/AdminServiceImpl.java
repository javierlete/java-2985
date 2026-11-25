package com.ipartek.formacion.spring.iparrestspring.servicios.impl;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.iparrestspring.entidades.Plato;
import com.ipartek.formacion.spring.iparrestspring.repositorios.PlatoRepository;
import com.ipartek.formacion.spring.iparrestspring.servicios.AdminService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@RequiredArgsConstructor

@Service
public class AdminServiceImpl implements AdminService {
	private final PlatoRepository platoRepository;

	@Override
	public Plato crearPlato(Plato plato) {
		if (plato.getId() != null) {
			log.warn("Se ha recibido un plato para crear con id: " + plato);

			plato.setId(null);
		}
		
		Plato platoInsertado = platoRepository.save(plato);
		
		log.info("Se ha creado este plato: " + platoInsertado);
		
		return platoInsertado;
	}

	@Override
	public void borrarPlato(Long id) {
		log.info("Se va a borrar el plato " + id);
		
		platoRepository.deleteById(id);
	}

}

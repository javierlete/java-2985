package com.ipartek.formacion.spring.iparrestspring.servicios.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.iparrestspring.entidades.Plato;
import com.ipartek.formacion.spring.iparrestspring.repositorios.PlatoRepository;
import com.ipartek.formacion.spring.iparrestspring.servicios.AnonimoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor

@Service
public class AnonimoServiceImpl implements AnonimoService {
	private final PlatoRepository platoRepository;
	
	@Override
	public Iterable<Plato> listadoPlatos() {
		log.info("Se ha pedido un listado de todos los platos");
		
		return platoRepository.findAll();
	}

	@Override
	public Optional<Plato> platoPorId(Long id) {
		log.info("Se ha pedido el plato " + id);
		
		return platoRepository.findById(id);
	}

}

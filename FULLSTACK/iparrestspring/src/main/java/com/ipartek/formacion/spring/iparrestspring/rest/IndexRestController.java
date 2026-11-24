package com.ipartek.formacion.spring.iparrestspring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.spring.iparrestspring.entidades.Plato;
import com.ipartek.formacion.spring.iparrestspring.servicios.AnonimoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/v2")
public class IndexRestController {
	private final AnonimoService anonimoService;
	
	@GetMapping("platos")
	public Iterable<Plato> get() {
		return anonimoService.listadoPlatos();
	}
}

package com.ipartek.formacion.spring.iparrestspring.rest;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ipartek.formacion.spring.iparrestspring.entidades.Plato;
import com.ipartek.formacion.spring.iparrestspring.servicios.AdminService;
import com.ipartek.formacion.spring.iparrestspring.servicios.AnonimoService;
import com.ipartek.formacion.spring.iparrestspring.servicios.ServiciosException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/v2/platos")
public class PlatoRestController {
	private final AnonimoService anonimoService;
	private final AdminService adminService;

	@GetMapping
	public Iterable<Plato> get() {
		return anonimoService.listadoPlatos();
	}

	@GetMapping("{id}")
	public Plato get(@PathVariable Long id) {
		Optional<Plato> plato = anonimoService.platoPorId(id);

		if (plato.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return plato.get();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Plato post(@RequestBody Plato plato) {
		return adminService.crearPlato(plato);
	}

	@PutMapping("{id}")
	public Plato put(@RequestBody Plato plato, @PathVariable Long id) {
		if (id != plato.getId()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		try {
			return adminService.modificarPlato(plato);
		} catch (ServiciosException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		adminService.borrarPlato(id);
	}
}

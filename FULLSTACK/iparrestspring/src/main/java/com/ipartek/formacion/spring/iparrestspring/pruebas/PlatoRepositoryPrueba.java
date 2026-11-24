package com.ipartek.formacion.spring.iparrestspring.pruebas;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ipartek.formacion.spring.iparrestspring.entidades.Plato;
import com.ipartek.formacion.spring.iparrestspring.repositorios.PlatoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Component
public class PlatoRepositoryPrueba implements CommandLineRunner {
	private final PlatoRepository repo;

	@Override
	public void run(String... args) throws Exception {
		repo.save(Plato.builder().nombre("Pizza").precio(new BigDecimal("12.34")).build());
		repo.save(Plato.builder().nombre("Ternera").precio(new BigDecimal("22.34")).build());

		for (Plato plato : repo.findAll()) {
			System.out.println(plato);
		}
		
		System.out.println(repo.findByNombreContains("a"));
		
		System.out.println(repo.nombresPlatosDestacados());
	}

}

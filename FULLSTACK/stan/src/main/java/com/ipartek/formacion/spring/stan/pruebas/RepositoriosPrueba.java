package com.ipartek.formacion.spring.stan.pruebas;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ipartek.formacion.spring.stan.entidades.Rol;
import com.ipartek.formacion.spring.stan.entidades.Usuario;
import com.ipartek.formacion.spring.stan.repositorios.RolRepository;
import com.ipartek.formacion.spring.stan.repositorios.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Component
public class RepositoriosPrueba implements CommandLineRunner {
	private final RolRepository rolRepository;
	private final UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {
		Rol admin = Rol.builder().nombre("ADMIN").build();
		Rol user = Rol.builder().nombre("USER").build();
		Rol escritor = Rol.builder().nombre("WRITER").build();

		rolRepository.saveAll(List.of(admin, user, escritor));

		Usuario javier = Usuario.builder().email("javier@email.net").password("javier").rol(admin).build();
		usuarioRepository.save(javier);

		Usuario miguel = Usuario.builder().email("miguel@email.net").password("miguel").rol(escritor).build();
		usuarioRepository.save(miguel);

		Usuario pepe = Usuario.builder().email("pepe@email.net").password("pepe").rol(Rol.builder().id(2L).build())
				.build();
		usuarioRepository.save(pepe);

		for (int i = 1; i <= 10; i++) {
			usuarioRepository.save(
					Usuario.builder().email("usuario" + i + "@email.net").password("usuario" + i).rol(user).build());
		}

		System.out.println("MOSTRANDO USUARIOS");

		for (Usuario usuario : usuarioRepository.findAll()) {
			System.out.println(usuario);
		}
	}

}

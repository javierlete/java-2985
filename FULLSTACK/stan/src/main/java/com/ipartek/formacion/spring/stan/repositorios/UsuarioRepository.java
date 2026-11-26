package com.ipartek.formacion.spring.stan.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.spring.stan.entidades.Usuario;

@RepositoryRestResource(path="usuarios", collectionResourceRel = "usuarios")
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}

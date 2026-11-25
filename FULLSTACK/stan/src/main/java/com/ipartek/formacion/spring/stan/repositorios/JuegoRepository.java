package com.ipartek.formacion.spring.stan.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.spring.stan.entidades.Juego;

@RepositoryRestResource(path="juegos", collectionResourceRel = "juegos")
public interface JuegoRepository extends CrudRepository<Juego, Long> {

}

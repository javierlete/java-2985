package com.ipartek.formacion.spring.iparrestspring.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.spring.iparrestspring.entidades.Plato;

@RepositoryRestResource(path = "platos", collectionResourceRel = "platos")
public interface PlatoRepository extends CrudRepository<Plato, Long> {
	Iterable<Plato> findByNombreContains(String texto);
	@Query("select p.nombre from Plato p order by p.nombre desc")
	Iterable<String> nombresPlatosDestacados();
}

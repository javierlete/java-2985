package com.ipartek.formacion.iparrest.jersey.rest;

import java.util.List;

import com.ipartek.formacion.iparrest.accesodatos.PlatoDaoJpa;
import com.ipartek.formacion.iparrest.entidades.Plato;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("platos")
public class PlatosRest {
	@GET
	public List<Plato> get() {
		return PlatoDaoJpa.obtenerTodos();
	}

	@GET
	@Path("{id}")
	public Plato getUno(@PathParam("id") Long id) {
		Plato plato = PlatoDaoJpa.obtenerPorId(id);

		if (plato == null) {
			throw new NotFoundException();
		}

		return plato;
	}

	@POST
	public Response post(Plato plato) {
		return Response.status(Status.CREATED).entity(PlatoDaoJpa.insertar(plato)).build();
	}

	@PUT
	@Path("{id}")
	public Plato put(Plato plato, @PathParam("id") Long id) {
		return PlatoDaoJpa.modificar(plato);
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Long id) {
		PlatoDaoJpa.borrar(id);
	}

}

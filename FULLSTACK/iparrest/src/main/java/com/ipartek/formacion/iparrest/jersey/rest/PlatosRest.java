package com.ipartek.formacion.iparrest.jersey.rest;

import java.util.ArrayList;

import com.ipartek.formacion.iparrest.accesodatos.PlatoDao;
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
	public ArrayList<Plato> get() {
		return PlatoDao.obtenerTodos();
	}

	@GET
	@Path("{id}")
	public Plato getUno(@PathParam("id") Long id) {
		Plato plato = PlatoDao.obtenerPorId(id);

		if (plato == null) {
			throw new NotFoundException();
		}

		return plato;
	}

	@POST
	public Response post(Plato plato) {
		return Response.status(Status.CREATED).entity(PlatoDao.insertar(plato)).build();
	}

	@PUT
	@Path("{id}")
	public Plato put(Plato plato, @PathParam("id") Long id) {
		return PlatoDao.modificar(plato);
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Long id) {
		PlatoDao.borrar(id);
	}

}

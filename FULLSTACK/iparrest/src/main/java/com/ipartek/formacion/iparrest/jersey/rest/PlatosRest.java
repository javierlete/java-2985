package com.ipartek.formacion.iparrest.jersey.rest;

import java.util.List;
import java.util.Map;

import com.ipartek.formacion.bibliotecas.validacion.ValidacionHelper;
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
		Map<String, String> errores = ValidacionHelper.validar(plato);

		if(!errores.isEmpty()) {
			return Response.status(Status.BAD_REQUEST).entity(errores).build();
		}
		
		Plato platoInsertado = PlatoDaoJpa.insertar(plato);
		
		return Response.status(Status.CREATED).entity(platoInsertado).build();
	}

	@PUT
	@Path("{id}")
	public Response put(Plato plato, @PathParam("id") Long id) {
		Map<String, String> errores = ValidacionHelper.validar(plato);

		if(!errores.isEmpty()) {
			return Response.status(Status.BAD_REQUEST).entity(errores).build();
		}
		
		return Response.ok().entity(PlatoDaoJpa.modificar(plato)).build();
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Long id) {
		PlatoDaoJpa.borrar(id);
	}

}

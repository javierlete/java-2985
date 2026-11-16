package com.ipartek.formacion.iparrest.jersey.rest;

import java.util.ArrayList;

import com.ipartek.formacion.iparrest.accesodatos.PlatoDao;
import com.ipartek.formacion.iparrest.entidades.Plato;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("platos")
public class PlatosRest {
	@GET
	public ArrayList<Plato> get() {
		return PlatoDao.obtenerTodos();
	}
	
	@GET
	@Path("{id}")
	public Plato getUno(@PathParam("id") Long id) {
		return PlatoDao.obtenerPorId(id);
	}
	
	@POST
	public Plato post(Plato plato) {
		return PlatoDao.insertar(plato);
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

package com.ipartek.formacion.iparrest.accesodatos;

import static com.ipartek.formacion.bibliotecas.jpa.JpaHelper.ejecutarJpa;

import java.util.List;

import com.ipartek.formacion.iparrest.entidades.Plato;

public class PlatoDaoJpa {
	
	public static List<Plato> obtenerTodos() {
		return ejecutarJpa(em -> em.createQuery("from Plato", Plato.class).getResultList());
	}

	public static Plato obtenerPorId(Long id) {
		return ejecutarJpa(em -> em.find(Plato.class, id));
	}

	public static Plato insertar(Plato plato) {
		return ejecutarJpa(em -> {
			em.persist(plato);
			return plato;
		});
	}

	public static Plato modificar(Plato plato) {
		return ejecutarJpa(em -> {
			em.merge(plato);
			return plato;
		});
	}

	public static void borrar(Long id) {
		ejecutarJpa(em -> {
			em.remove(em.find(Plato.class, id));
			return null;
		});
	}
}

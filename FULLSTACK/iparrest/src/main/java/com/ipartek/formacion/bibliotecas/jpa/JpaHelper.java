package com.ipartek.formacion.bibliotecas.jpa;

import java.util.function.Function;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaHelper {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades");

	public static <T> T ejecutarJpa(Function<EntityManager, T> codigo) {
		EntityManager em = null;
		EntityTransaction t = null;

		try {
			em = emf.createEntityManager();
			t = em.getTransaction();
			t.begin();

			T resultado = codigo.apply(em);

			t.commit();

			return resultado;
		} catch (Exception e) {
			if (t != null && t.isActive()) {
				t.rollback();
			}

			throw new AccesoDatosException("No se ha podido hacer la operación JPA", e);
		} finally {
			em.close();
		}
	}
}

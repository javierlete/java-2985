package com.ipartek.formacion.iparrest.accesodatos;

import java.util.List;

import com.ipartek.formacion.iparrest.entidades.Plato;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PlatoDaoJpa {
	private static final EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("com.ipartek.formacion.iparrest.entidades");

	public static List<Plato> obtenerTodos() {
		EntityManager em = null;
		EntityTransaction t = null;

		try {
			em = emf.createEntityManager();
			t = em.getTransaction();
			t.begin();

			List<Plato> platos = em.createQuery("from Plato", Plato.class).getResultList();

			t.commit();

			return platos;
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			
			throw e;
		}
	}

	public static Plato obtenerPorId(Long id) {
		EntityManager em = null;
		EntityTransaction t = null;

		try {
			em = emf.createEntityManager();
			t = em.getTransaction();
			t.begin();

			Plato plato = em.find(Plato.class, id);
			
			t.commit();

			return plato;
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			
			throw e;
		}
	}

	public static Plato insertar(Plato plato) {
		EntityManager em = null;
		EntityTransaction t = null;

		try {
			em = emf.createEntityManager();
			t = em.getTransaction();
			t.begin();

			em.persist(plato);
			
			t.commit();

			return plato;
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			
			throw e;
		}
	}

	public static Plato modificar(Plato plato) {
		EntityManager em = null;
		EntityTransaction t = null;

		try {
			em = emf.createEntityManager();
			t = em.getTransaction();
			t.begin();

			em.merge(plato);
			
			t.commit();

			return plato;
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			
			throw e;
		}
	}

	public static void borrar(Long id) {
		EntityManager em = null;
		EntityTransaction t = null;

		try {
			em = emf.createEntityManager();
			t = em.getTransaction();
			t.begin();

			em.remove(em.find(Plato.class, id));
			
			t.commit();
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			
			throw e;
		}
	}
}

package com.ipartek.formacion.gestionalmacen.pruebas;

import java.util.ArrayList;

public class Interfaces {
	public static void main(String[] args) {
		ArrayList<Rodable> saco = new ArrayList<>();

		saco.add(new Naranja());
		saco.add(new Balon());

		for (Rodable r : saco) {
			if (r instanceof Comestible c) {
				c.comer();
			}

			r.rodar();

			if (r instanceof Comestible c) {
				c.comer();
			}
		}
	}
}

class Fruto {
}

class ObjetoDeporte {
}

interface Rodable {
	void rodar();
}

interface Comestible {
	void comer();
}

class Balon extends ObjetoDeporte implements Rodable {
	@Override
	public void rodar() {
		System.out.println("Balon rodando");
	}
}

class Naranja extends Fruto implements Rodable, Comestible {
	private boolean porElSuelo = false;

	@Override
	public void comer() {
		System.out.println(porElSuelo ? "PUAGH QUE ASCO" : "Ñam que rica");
	}

	@Override
	public void rodar() {
		System.out.println("Naranja rodando");
		porElSuelo = true;
	}
}

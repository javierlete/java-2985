private static final String FORMATO = "%-10s %-20s\n";
private static final Asistente[] asistentes = new Asistente[2];

void main() {
	System.setProperty("stdin.encoding", "UTF-8");
	System.setProperty("stdout.encoding", "UTF-8");

//	IO.println("Entrada: " + System.getProperty("stdin.encoding"));
//	IO.println("Salida: " + System.getProperty("stdout.encoding"));

	int opcion;

	do {
		mostrarOpciones();
		opcion = Integer.parseInt(IO.readln("Dime qué opción quieres: "));
		procesarOpcion(opcion);
	} while (opcion != 0);
}

private void mostrarOpciones() {
	IO.println("""

			MENU
			====

			1. Recibir asistentes
			2. Mostrar asistentes

			0. Salir

			""");
}

private void procesarOpcion(int opcion) {
	switch (opcion) {
	case 1 -> recibirAsistentes();
	case 2 -> listado();
	case 0 -> IO.println("Gracias por usar la aplicación");
	default -> IO.println("NO reconozco esa opción");
	}
}

private void recibirAsistentes() {
	int indice = 0;

	do {
		asistentes[indice++] = pedirAsistente();
	} while (indice < asistentes.length);

	IO.println("Ya no se admiten más asistentes");
}

private Asistente pedirAsistente() {
	String nombre = IO.readln("Dame el nombre: ");
	String apellidos = IO.readln("Dame los apellidos: ");

	Asistente asistente = new Asistente(nombre, apellidos);
	return asistente;
}

private void listado() {
	IO.println("""
			Listado de asistentes
			---------------------
			""");

	System.out.printf(FORMATO, "Nombre", "Apellidos");
	System.out.printf(FORMATO, "======", "=========");

	for (Asistente asistente : asistentes) {
		System.out.printf(FORMATO, asistente.nombre(), asistente.apellidos());
	}
}

private record Asistente(String nombre, String apellidos) {
}
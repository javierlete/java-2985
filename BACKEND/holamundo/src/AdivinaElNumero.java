void main() {
	Random aleatorio = new Random();
	int numeroAleatorio = aleatorio.nextInt(1, 10);

	int numero;

	String resultado;

	do {
		numero = Integer.parseInt(IO.readln("Dime un número de 1 a 10: "));

		if (numeroAleatorio < numero) {
			resultado = "Es menor";
		} else if (numeroAleatorio > numero) {
			resultado = "Es MAYOR";
		} else {
			resultado = "¡HAS ACERTADO!";
		}

		IO.println(resultado);
	} while (numero != numeroAleatorio);

	IO.println("Gracias por usar este juego");
}

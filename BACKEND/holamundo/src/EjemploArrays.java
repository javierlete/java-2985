void main() {
	int[] arr = new int[3];

	arr[0] = 5;
	arr[1] = 6;
	arr[2] = 7;

	arr[1] = 10;
//	arr[3] = 8; // No se puede. Da un ArrayIndexOutOfBoundsException

//	arr = new int[10];

	IO.println(Arrays.toString(arr));

	for (int i = 0; i < arr.length; i++) {
		IO.print(arr[i] + " ");
	}

	for (int dato : arr) {
		IO.print(dato + " ");
	}

	IO.println();

	char[][] tablero = new char[8][8];

	tablero[0][0] = 'T';
	tablero[0][1] = 'C';
	tablero[7][7] = 't';

	for (char[] fila : tablero) {
		IO.println(Arrays.toString(fila));
	}

	for (char[] fila : tablero) {
		for (char columna : fila) {
			IO.print((columna != 0 ? columna : '.') + " ");
		}

		IO.println();
	}
	
	for (int fila = 0; fila < tablero.length; fila++) {
		for (int columna = 0; columna < tablero[fila].length; columna++) {
			char caracter = tablero[fila][columna];
			IO.print((caracter != 0 ? caracter : '.') + " ");
		}

		IO.println();
	}
}

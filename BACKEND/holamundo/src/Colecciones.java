void main() {
	ArrayList<Integer> enteros = new ArrayList<Integer>();
	
	enteros.add(5);
	enteros.add(6);
	enteros.add(7);
	
	enteros.addFirst(4);
	enteros.addFirst(3);
	enteros.addFirst(2);
	enteros.addFirst(1);
	
	System.out.println(enteros);
	
	enteros.add(0, 4);
	enteros.remove(2);
	
	enteros.set(1, 10);
	
	System.out.println(enteros);
	
	for(Integer entero: enteros) {
		IO.println(entero);
	}
}
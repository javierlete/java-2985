// Función constructora
function Persona(id, nombre, apellidos) {
    this.id = id;
    this.nombre = nombre;
    this.apellidos = apellidos;
}

Persona.prototype.nombreCompleto = function () {
    return `${this.nombre} ${this.apellidos}`;
}

const persona1 = new Persona(1, 'Javier', 'Lete');

console.log(persona1, typeof persona1);

persona1.ciudad = 'Bilbao';

console.log(persona1, typeof persona1);

const persona2 = new Persona();

console.log(persona2);

console.log(persona1.nombreCompleto());
console.log(persona2.nombreCompleto());

console.log('Hola'.toUpperCase());

String.prototype.toUpperCase = function () { // NO SE DEBE HACER
    return 'Te joooooodeeeees';
}

console.log('Hola'.toUpperCase());

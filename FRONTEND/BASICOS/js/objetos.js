'use strict';

const objeto = { id: 1 };

console.log(objeto);

objeto.nombre = 'Javier';
objeto['apellidos'] = 'Lete'; // Atípico
objeto['nombre-completo'] = 'Pepe Pérez'; // Atípico

console.log(typeof objeto, objeto, objeto.nombre);

// const campo = prompt('Dime qué campo quieres leer');

// console.log(objeto[campo]);

objeto.id = 2;

console.log(objeto);

objeto.amigo = { id: 3, nombre: 'Pepe' };

console.log(objeto, objeto.amigo.nombre);

delete objeto['nombre-completo'];

console.log(objeto);

objeto.nombreCompleto = function () {
    return `${this.nombre} ${this.apellidos}`;
};

console.log(objeto.nombreCompleto());

const objeto2 = { id: 2, nombre: 'Pepe', apellidos: 'Pérez' };

objeto2.nombreCompleto = objeto.nombreCompleto;

console.log(objeto2.nombreCompleto());

function nombreCompleto(o) {
    return `${o.nombre} ${o.apellidos}`;
}

console.log(nombreCompleto(objeto));

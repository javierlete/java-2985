/*
 * Nuestro primer ejemplo de JavaScript
 * Haremos cosas pequeñas para empezar
 */

'use strict';

console.log('Hola mundo'); // muestra una texto en consola

console.log('\'');
console.log("'");
console.log("\"");
console.log('"');

console.log('Hola que tal\nComo estamos');

console.log(`
Texto
multilínea`);

console.log(5 + 5);

console.log(5 / 0);

console.log(Math.sqrt(2));

console.log(Math.SQRT2);

console.log(typeof 5);

console.log(typeof '5');

console.log(typeof NaN);

console.log(isNaN(Math.sqrt('asdfasdf')) ? 'Verdadero' : 'Falso');

console.log('5' + '3');

console.log('5' == 5);

console.log('5' === 5);

console.log(true && true);

// console.log(nombre); // var lo permite, let no

let nombre;

console.log(nombre);

nombre = 'Javier';

console.log('Hola ' + nombre);

nombre = 'Pepe';

console.log('Hola ' + nombre);

const nombreIntroducido = prompt('¿Cómo te llamas?');

const saludo = 'Hola ' + nombreIntroducido;

alert(saludo);

const a = +prompt('Dime un número');
const b = parseFloat(prompt('Dime otro número'));

if (isNaN(a) || isNaN(b)) {
    alert('LA PRÓXIMA VEZ METE UN NÚMERO, LISTO');
} else {
    const suma = a + b;

    alert(suma);

    const IVA = 0.21;

    const importeConIva = suma * (IVA + 1);

    alert(importeConIva);
}

console.log('Fin del programa');
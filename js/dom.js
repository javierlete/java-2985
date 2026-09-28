'use strict';

window.addEventListener('DOMContentLoaded', () => {

    const h1 = document.querySelector('h1');

    console.log(h1);
    console.log(h1.innerText);

    h1.innerText = 'Ejemplo de JavaScript';

    const inputNombre = document.querySelector('#nombre');
    const boton = document.querySelector('button');
    const saludo = document.querySelector('#resultado');

    boton.addEventListener('click', botonPulsado);

    function botonPulsado() {
        saludo.innerText = 'Hola ' + inputNombre.value;
    }
});
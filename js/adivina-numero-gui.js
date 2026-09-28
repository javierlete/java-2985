'use strict';

const numeroAdivinar = Math.floor(Math.random() * 10) + 1;

console.log(numeroAdivinar);

window.addEventListener('DOMContentLoaded', () => { // Esperamos a la carga del DOM
    // Ya ha cargado todo el DOM completo

    // 1. RECOGER TODOS LOS ELEMENTOS CON LOS QUE NECESITAMOS INTERACTUAR
    const form = document.forms[0]; // document.querySelector('#form-adivina'); // document.getElementById('form-adivina');
    const inputNumero = form.numero; // document.querySelector('input[name=numero]');
    const resultados = document.querySelector('#resultados'); // document.getElementById('resultados');

    const verde = document.querySelector('#verde');
    const rojo = document.querySelector('#rojo');

    // 2. ASOCIAR EVENTOS CON ACCIONES
    form.addEventListener('submit', procesarNumero); // Capturamos el evento de envío de formulario

    // 3. GESTORES DE EVENTOS
    function procesarNumero(evento) {
        // A. CANCELAR PROPAGACIÓN DEL EVENTO SUBMIT (EN EL RESTO NO ES NECESARIO)
        evento.preventDefault();

        // B. LEER Y CONVERTIR LOS DATOS
        const numero = parseInt(inputNumero.value);

        // C. HACER ALGO CON LA INFORMACIÓN
        let mensaje;
        let acertado = false;

        if (numeroAdivinar > numero) {
            mensaje = 'Es mayor que ' + numero;
        } else if (numeroAdivinar < numero) {
            mensaje = 'Es menor que ' + numero;
        } else {
            mensaje = 'Has acertado';
            acertado = true;
        }

        // D. MODIFICAR LA PANTALLA
        if(acertado) {
            resultados.innerHTML = '';

            rojo.style.display = 'none';
            verde.style.display = 'block';
        } else {
            const li = document.createElement('li');
            
            li.innerText = mensaje;
            
            resultados.appendChild(li);

            rojo.style.display = 'block';
            verde.style.display = 'none';
        }
    }
});

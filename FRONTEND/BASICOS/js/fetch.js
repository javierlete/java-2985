'use strict';

window.addEventListener('DOMContentLoaded', async () => {
    const ul = document.querySelector('ul');

    const respuesta = await fetch('json/productos.json'); // Petición del recurso externo

    console.log(respuesta);

    const productos = await respuesta.json(); // Conversión de JSON como texto a elementos de JavaScript

    console.log(productos);

    for (const producto of productos) { // Por cada producto que haya en productos
        console.log(producto);

        const li = document.createElement('li');

        li.innerHTML = `<strong>${producto.nombre}</strong>: ${producto.precio}`;

        ul.appendChild(li);
    }
});
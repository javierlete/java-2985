'use strict';

window.addEventListener('DOMContentLoaded', async () => {
    const ul = document.querySelector('ul');

    const respuesta = await fetch('json/productos.json');

    console.log(respuesta);

    const productos = await respuesta.json();

    console.log(productos);

    for(const producto of productos) {
        console.log(producto);

        const li = document.createElement('li');

        li.innerHTML = `<strong>${producto.nombre}</strong>: ${producto.precio}`;

        ul.appendChild(li);
    }
});
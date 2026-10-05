'use strict';

const URL = 'http://localhost:3001/productos/';

let catalogo;
let detalle;

window.addEventListener('DOMContentLoaded', domCargado);

async function domCargado() {
    catalogo = document.querySelector('#catalogo');
    detalle = document.querySelector('#detalle');

    const marco = document.querySelector('#marco-catalogo');

    detalle.style.display = 'none';

    const respuesta = await fetch(URL);
    const productos = await respuesta.json();

    for(const producto of productos) {
        const div = document.createElement('div');

        div.className = 'col';

        div.innerHTML = `
            <div class="card h-100">
                <img src="imgs/${producto.imagen}" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">${producto.nombre}</h5>
                    <p class="card-text">${producto.descripcion}</p>
                    <p>
                        <a href="javascript:mostrarDetalle(${producto.id})" class="btn btn-primary">Ver detalle</a>
                    </p>
                </div>
                <div class="card-footer">
                    <small class="text-body-secondary">${producto.precio}</small>
                </div>
            </div>
        `;

        marco.appendChild(div);
    }
}

async function mostrarDetalle(id) {
    const respuesta = await fetch(URL + id);
    const producto = await respuesta.json();

    catalogo.style.display = 'none';
    detalle.style.display = 'block';

    document.querySelector('#detalle img').src = 'imgs/' + producto.imagen;
    document.querySelector('#detalle .card-title').textContent = producto.nombre;
    document.querySelector('#detalle .card-title + .card-text').textContent = producto.descripcion;
    document.querySelector('#detalle small').textContent = producto.precio;
}

function mostrarCatalogo() {
    catalogo.style.display = 'block';
    detalle.style.display = 'none';
}
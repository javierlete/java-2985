'use strict';

const URL = 'json/amazonia.json';

window.addEventListener('DOMContentLoaded', domCargado);

async function domCargado() {
    const catalogo = document.querySelector('#catalogo');
    const detalle = document.querySelector('#detalle');
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
                        <a href="#" class="btn btn-primary">Ver detalle</a>
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
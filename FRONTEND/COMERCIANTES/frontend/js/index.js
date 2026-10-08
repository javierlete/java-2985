'use strict';

let idioma = "es";
let recargar;

const URL_COMERCIOS = 'http://localhost:3000/comercios/';
const URL_CATEGORIAS = 'http://localhost:3000/categorias/';
const URL_COMERCIOS_CATEGORIAS = 'http://localhost:3000/comercios_categorias/';

mostrarAsociados();

cargarSelectorCategorias();

const selectCategorias = document.querySelector('#selector-categorias');

selectCategorias.addEventListener('change', buscarComercioPorCategoria);

async function buscarComercioPorCategoria(e) {
    const categoriaId = parseInt(e.target.value);

    console.log(categoriaId);

    if (!categoriaId) {
        mostrarAsociados();
        return;
    }

    const respuesta = await fetch(URL_COMERCIOS_CATEGORIAS + '?categoria_id=' + categoriaId);
    const comerciosCategorias = await respuesta.json();

    const comercios = [];

    for (const comercioCategoria of comerciosCategorias) {
        const id = comercioCategoria.comercios_id;

        const respuestaComercio = await fetch(URL_COMERCIOS + id);
        const comercio = await respuestaComercio.json();

        comercios.push(comercio);
    }

    cargarAsociados(comercios);
}

async function cargarSelectorCategorias() {
    const respuesta = await fetch(URL_CATEGORIAS);
    const categorias = await respuesta.json();

    const texto = idioma === 'es' ? 'Selecciona la categoría' : 'Seleccionatu la categoriatu';

    const optionVacio = document.createElement('option');
    optionVacio.value = 0;
    optionVacio.textContent = texto;
    optionVacio.disabled = true;
    optionVacio.selected = true;

    selectCategorias.appendChild(optionVacio);

    for (const categoria of categorias) {
        const option = document.createElement('option');
        option.value = categoria.id;

        option.textContent = categoria['nombre_' + idioma];

        selectCategorias.appendChild(option);
    }
}

function cambiarIdioma(i) {
    idioma = i;

    recargar();
}

async function mostrarAsociados() {
    recargar = mostrarAsociados;

    selectCategorias.value = 0;

    mostrar('asociados');

    const respuesta = await fetch(URL_COMERCIOS);
    const comercios = await respuesta.json();

    cargarAsociados(comercios);
}

function cargarAsociados(comercios) {
    const listado = document.querySelector('#listado-asociados');

    listado.innerHTML = '';

    for (const comercio of comercios) {
        const card = document.createElement('article');

        card.className = 'col';

        card.innerHTML = `
            <div class="card h-100">
                <img src="https://picsum.photos/400/300?${comercio.id}" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">${comercio['nombre_' + idioma]}</h5>
                    <p class="card-text">
                        ${comercio['horario_' + idioma]}
                    </p>
                    <p class="card-text">
                        <a href="https://www.google.com/maps/search/?api=1&query=${comercio.latitud},${comercio.longitud}"><i class="bi bi-map"></i></a>
                    </p>
                </div>
                <div class="card-footer">
                    <small class="text-body-secondary">
                        <a href="tel:${comercio.telefono}"><i class="bi bi-phone"></i>${comercio.telefono}</a>
                    </small>
                </div>
            </div>
        `;

        listado.appendChild(card);
    }
}

function mostrar(id) {
    const secciones = document.querySelectorAll('main>section');

    for (const seccion of secciones) {
        if (seccion.id === id) {
            seccion.classList.remove('d-none');
        } else {
            seccion.classList.add('d-none');
        }
    }
}
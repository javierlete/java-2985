'use strict';

const URL_PRODUCTOS = 'http://localhost:3001/productos/';

window.addEventListener('DOMContentLoaded', domCargado);

function domCargado() {
    // TODO: mostrarCatalogo();
    mostrarAdministracion();
}

async function mostrarDetalle(id) {
    const respuesta = await fetch(URL_PRODUCTOS + id);
    const producto = await respuesta.json();

    mostrar('detalle');

    document.querySelector('#detalle img').src = 'imgs/' + producto.imagen;
    document.querySelector('#detalle .card-title').textContent = producto.nombre;
    document.querySelector('#detalle .card-title + .card-text').textContent = producto.descripcion;
    document.querySelector('#detalle small').textContent = producto.precio;
}

async function mostrarCatalogo() {
    const marco = document.querySelector('#marco-catalogo');

    marco.innerHTML = '';

    // TODO: Gestionar el posible error de que no está arrancado el json-server
    const respuesta = await fetch(URL_PRODUCTOS);
    const productos = await respuesta.json();

    for (const producto of productos) {
        const div = document.createElement('div');

        div.className = 'col';

        div.innerHTML = `
            <article class="card h-100">
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
            </article>
        `;

        marco.appendChild(div);
    }

    mostrar('catalogo');
}

async function mostrarAdministracion() {
    mostrar('administracion');

    const tbody = document.querySelector('#administracion tbody');

    tbody.innerHTML = '';

    const respuesta = await fetch(URL_PRODUCTOS);
    const productos = await respuesta.json();

    for (const producto of productos) {
        const tr = document.createElement('tr');

        tr.innerHTML = `
            <th>${producto.id}</th>
            <td>${producto.nombre}</td>
            <td>${producto.precio}</td>
            <td>
                <a href="javascript:mostrarFormulario(${producto.id})" class="btn btn-sm btn-primary"><i class="bi bi-pencil-fill"></i></a>
                <a 
                    data-bs-toggle="modal"
                    data-bs-target="#confirmacion"
                    data-jl-modal-texto="¿Estás seguro de que quieres borrar ${producto.nombre}?"
                    data-jl-modal-si="borrarProducto(${producto.id})"
                    href="#"
                    class="btn btn-sm btn-danger"><i class="bi bi-trash-fill"></i></a>
            </td>`;

        tbody.appendChild(tr);
    }
}

function mostrar(idSeccion) {
    const secciones = document.querySelectorAll('main>section');

    for (const seccion of secciones) {
        seccion.classList.add('d-none');
    }

    // const seccionMostrar = document.getElementById(idSeccion);
    const seccionMostrar = document.querySelector('#' + idSeccion);
    seccionMostrar.classList.remove('d-none');
}

async function borrarProducto(id) {
    const respuesta = await fetch(URL_PRODUCTOS + id, { method: 'DELETE' });

    if (respuesta.ok) {
        mostrarAdministracion();
    }
}

async function mostrarFormulario(id) {
    mostrar('formulario');

    const form = document.querySelector('#formulario form');

    if (!id) {
        form.reset();
        return;
    }

    const respuesta = await fetch(URL_PRODUCTOS + id);
    const producto = await respuesta.json();


    form['id-producto'].value = producto.id;
    form.nombre.value = producto.nombre;
    form.imagen.value = producto.imagen;
    form.descripcion.value = producto.descripcion;
    form.precio.value = producto.precio;
    form.ean.value = producto.ean;
}

async function guardar() {
    const form = document.querySelector('#formulario form');

    const id = parseInt(form['id-producto'].value);

    const producto = {
        nombre: form.nombre.value,
        imagen: form.imagen.value,
        ean: form.ean.value,
        descripcion: form.descripcion.value,
        precio: parseFloat(form.precio.value)
    };

    console.log(producto);

    if (id) {
        // PUT
        producto.id = id;

        const respuesta = await fetch(URL_PRODUCTOS + producto.id, {
            method: 'PUT',
            body: JSON.stringify(producto),
            headers: {
                'Content-type': 'application/json'
            }
        });

        const productoModificado = await respuesta.json();

        console.log(productoModificado);
    } else {
        // POST
        const respuesta = await fetch(URL_PRODUCTOS, {
            method: 'POST',
            body: JSON.stringify(producto),
            headers: {
                'Content-type': 'application/json'
            }
        });

        const productoInsertado = await respuesta.json();

        console.log(productoInsertado);
    }

    mostrarAdministracion();
}
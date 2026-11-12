const URL_PLATOS = 'api/v1/platos/';

const ul = document.querySelector('ul');

const respuesta = await fetch(URL_PLATOS);
const platos = await respuesta.json();

for (const plato of platos) {
    const li = document.createElement('li');

    li.textContent = `${plato.nombre}: ${plato.precio}`;

    ul.appendChild(li);
}

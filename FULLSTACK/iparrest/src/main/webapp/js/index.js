const URL_PLATOS = 'api/v1/platos/';

const ul = document.querySelector('ul');
const pre = document.querySelector('pre');

const respuesta = await fetch(URL_PLATOS);
const platos = await respuesta.json();

for (const plato of platos) {
    const li = document.createElement('li');
	const a = document.createElement('a');

    a.textContent = `${plato.nombre}: ${plato.precio}`;
	a.href="#";
	a.addEventListener('click', () => verPlato(plato.id));
	
	li.appendChild(a);

    ul.appendChild(li);
}

async function verPlato(id) {
	const respuesta = await fetch(URL_PLATOS + id);
	const plato = await respuesta.json();
	
	console.log(plato);
	
	pre.textContent = plato.descripcion;
}
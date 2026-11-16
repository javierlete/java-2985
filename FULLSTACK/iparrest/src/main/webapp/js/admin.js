const URL_PLATOS = 'api/v1/platos/';

const form = document.querySelector('form');

form.addEventListener('submit', async e => {
    e.preventDefault();

    const plato = {
		nombre: form.nombre.value,
		precio: Number(form.precio.value),
		descripcion: form.descripcion.value,
	};
	
	console.log(plato);
	
	const respuesta = await fetch(URL_PLATOS, {
		method: 'POST',
		body: JSON.stringify(plato),
		headers: {
			'Content-type': 'application/json',
		},
	});
	
	console.log(respuesta);
	
	const platoRecibido = await respuesta.json();
	
	console.log(platoRecibido);
});












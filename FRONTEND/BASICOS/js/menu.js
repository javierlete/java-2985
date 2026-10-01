const btnHamburguesa = document.querySelector('#btn-hamburguesa');
const menuHamburguesa = document.querySelector('#menu-hamburguesa');

console.log(btnHamburguesa, menuHamburguesa);

btnHamburguesa.addEventListener('click', mostrarOcultarMenu);

function mostrarOcultarMenu() {
    console.log('mostrarOcultarMenu');

    if (menuHamburguesa.classList.contains('oculto')) {
        menuHamburguesa.classList.remove('oculto');
    } else {
        menuHamburguesa.classList.add('oculto');
    }

    // if(menuHamburguesa.style.display !== 'none') {
    //     menuHamburguesa.style.display = 'none';
    // } else {
    //     menuHamburguesa.style.display = 'block';
    // }
}
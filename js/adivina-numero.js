const numeroAdivinar = Math.floor(Math.random() * 10) + 1;

console.log(numeroAdivinar);

let numero;

do {
    numero = parseInt(prompt('Dime un número'));

    if (numeroAdivinar > numero) {
        alert('Es mayor');
    } else if (numeroAdivinar < numero) {
        alert('Es menor');
    } else {
        alert('Has acertado');
    }
} while (numeroAdivinar !== numero);

// 5! = 5 * 4 * 3 * 2 * 1
function factorial(numero) {
    let resultado = 1;

    for (let factor = numero; factor > 1; factor--) {
        resultado *= factor; // resultado = resultado * factor;
    }

    return resultado;
}

console.log(factorial(5));

const resultadoFactorial3 = factorial(3);

console.log(resultadoFactorial3);

let operacion;

operacion = sumar;

console.log(operacion(5, 6));

operacion = function (a, b) { // Función anónima
    return a - b;
};

console.log(operacion(5, 6));

operacion = (a, b) => a * b; // Arrow functions

console.log(operacion(5, 6));

function sumar(a, b) {
    return a + b;
}
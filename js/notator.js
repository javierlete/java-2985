const nota = +prompt('Dime la nota');

let calificacion;

switch (nota) {
    case 0:
    case 1:
    case 2:
    case 3: calificacion = 'Muy deficiente'; break;
    case 4: calificacion = 'Insuficiente'; break;
    case 5: calificacion = 'Suficiente'; break;
    case 6:
    case 7: calificacion = 'Bien'; break;
    case 8: calificacion = 'Notable'; break;
    case 9:
    case 10: calificacion = 'Sobresaliente'; break;
    default: calificacion = 'DESCONOCIDA';
}

alert(calificacion);
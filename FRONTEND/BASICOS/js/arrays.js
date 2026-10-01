const numeros = []; //new Array(3);

numeros[0] = 5;
numeros[1] = 6;
numeros[2] = 7;

numeros[3] = 8;
numeros[10] = 20;
numeros[7] = 'Hola';
numeros['perro'] = 'dog';
numeros.casa = 'house';
numeros.push('otro');

console.log(numeros, numeros.length, numeros[0], numeros['perro'], numeros.perro, numeros['casa']);

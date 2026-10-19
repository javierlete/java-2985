import { Ficha } from "./Contenido/Ficha";

export function Contenido() {
    const productos = [
        { id: 1, nombre: 'Portátil', precio: 1234.12, stock: 5 },
        { id: 2, nombre: 'Teclado', precio: 123.12, stock: 10 },
        { id: 3, nombre: 'Ratón', precio: 12.12, stock: 20 },
    ];

    return (
        <main className="container my-3">
            <div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 g-4">
                {productos.map(producto =>
                    <div className="col">
                        <Ficha producto={producto} />
                    </div>
                )}
            </div>
        </main>
    )
}
import { useEffect, useState } from "react";
import { Ficha } from "./Ficha";

const URL_PRODUCTOS = "json/productos.json";

export function Listado() {
    const [productos, setProductos] = useState([]);
    
    // useEffect(() => {
    //     fetch(URL_PRODUCTOS).then(
    //         respuesta => respuesta.json().then(
    //             productos => setProductos(productos)
    //         ));
    // }, []);

    useEffect(() => {
        async function cargarDatos() {
            const respuesta = await fetch(URL_PRODUCTOS);
            const productos = await respuesta.json();

            setProductos(productos);
        }

        cargarDatos();
    }, []);

    // useEffect(() => {
    //     (async function () {
    //         const respuesta = await fetch(URL_PRODUCTOS);
    //         const productos = await respuesta.json();

    //         setProductos(productos);
    //     })(); // IIFE
    // }, []);

    return (
        <>
            <div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 g-4">
                {productos.map(producto =>
                    <div key={producto.id} className="col">
                        <Ficha producto={producto} />
                    </div>
                )}
            </div>
        </>
    )
}
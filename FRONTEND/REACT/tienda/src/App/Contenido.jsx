import { Ficha } from "./Contenido/Ficha";

export function Contenido() {
    return (
        <main className="container my-3">
            <div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 g-4">
                <div className="col">
                    <Ficha />
                </div>
                <div className="col">
                    <Ficha />
                </div>
                <div className="col">
                    <Ficha />
                </div>
                <div className="col">
                    <Ficha />
                </div>
                <div className="col">
                    <Ficha />
                </div>
                <div className="col">
                    <Ficha />
                </div>
            </div>
        </main>
    )
}
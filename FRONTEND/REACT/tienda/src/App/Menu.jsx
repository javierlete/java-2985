import { NavLink } from "react-router";

export function Menu() {
    return (
        <nav className="navbar navbar-expand-sm bg-dark" data-bs-theme="dark">
            <div className="container-fluid">
                <a className="navbar-brand" href="#">Tienda</a>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav me-auto mb-2 mb-sm-0">
                        <li className="nav-item">
                            <NavLink className="nav-link" to="/" end>Principal</NavLink>
                        </li>
                    </ul>
                    <ul className="navbar-nav mb-2 mb-sm-0">
                        <li className="nav-item">
                            <NavLink className="nav-link" to="/admin" end>Administración</NavLink>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    )
}
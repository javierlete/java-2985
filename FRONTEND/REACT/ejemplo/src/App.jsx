import { useState } from 'react';
import './App.css'
import { Listado } from './Listado'
import { Login } from './Login'
import { Titulo } from './Titulo'

function App() {
  const [usuario, setUsuario] = useState(null);

  return (
    <>
      <h1>Ejemplo</h1>
      <Titulo texto="Prueba" />
      <Login onLogin={usuarioLogin => setUsuario(usuarioLogin)} />
      {usuario ? 
        <p>{usuario.email}</p> : 
        <p>No hay usuario</p>
      }
      {usuario && <Listado elementos={[ 'Prueba1', 'Prueba2' ]} />}
    </>
  )
}

export default App

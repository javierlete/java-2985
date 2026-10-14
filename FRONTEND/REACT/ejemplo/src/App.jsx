import './App.css'
import { Login } from './Login'
import { Titulo } from './Titulo'

function App() {
  return (
    <>
      <h1>Ejemplo</h1>
      <Titulo texto="Prueba" />
      <Login onLogin={dato => alert('El resultado es ' + (dato ? dato.email : 'No logueado'))} />
      
    </>
  )
}

export default App

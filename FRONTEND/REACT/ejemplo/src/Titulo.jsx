import './Titulo.css'

export function Titulo({ texto = 'SIN TITULO' }) {
  return (
    <>
      <h1>{texto}</h1>
    </>
  )
}

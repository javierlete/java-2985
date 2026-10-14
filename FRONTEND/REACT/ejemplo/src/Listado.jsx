export function Listado({ elementos }) {
    return (
        <>
            <ul>
                {elementos.map(e => <li>{e}</li>)}
            </ul>
        </>
    )
}

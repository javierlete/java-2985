export function Listado({ elementos }) {
    return (
        <>
            <ul>
                {elementos.map(e => <li key={e}>{e}</li>)}
            </ul>
        </>
    )
}

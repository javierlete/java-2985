import './ProductRow.css';

export function ProductRow({ product }) {
    return (
        <>
            <tr>
                <td className={!product.stocked ? 'nostock' : ''}>{product.name}</td><td>{product.price}</td>
            </tr>
        </>
    );
}
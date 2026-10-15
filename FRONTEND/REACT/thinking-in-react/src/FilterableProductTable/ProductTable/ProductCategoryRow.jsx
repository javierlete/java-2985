import './ProductCategoryRow.css';

export function ProductCategoryRow({ category }) {
    return (
        <>
            <tr>
                <th className="category" colSpan="2">{category}</th>
            </tr>
        </>
    );
}
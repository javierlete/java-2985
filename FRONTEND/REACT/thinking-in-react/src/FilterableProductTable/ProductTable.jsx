import './ProductTable.css';
import { ProductCategoryRow } from "./ProductTable/ProductCategoryRow";
import { ProductRow } from "./ProductTable/ProductRow";

export function ProductTable({ products }) {
    let lastCategory;

    return (
        <>
            <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    {products.map(product =>
                        <>
                            {product.category !== lastCategory &&
                                <ProductCategoryRow key={product.category} category={lastCategory = product.category} />}
                            <ProductRow key={product.name} product={product} />
                        </>
                    )}
                </tbody>
            </table>
        </>
    );
}
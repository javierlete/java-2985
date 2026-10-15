import './ProductTable.css';
import { ProductCategoryRow } from "./ProductTable/ProductCategoryRow";
import { ProductRow } from "./ProductTable/ProductRow";

export function ProductTable({ products, filterText, inStockOnly }) {
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
                        { (product.name.toLowerCase().includes(filterText.toLowerCase())) && (!inStockOnly || product.stocked) && //     !(inStockOnly && !product.stocked)
                            <ProductRow key={product.name} product={product} />
                        }
                        </>
                    )}
                </tbody>
            </table>
        </>
    );
}
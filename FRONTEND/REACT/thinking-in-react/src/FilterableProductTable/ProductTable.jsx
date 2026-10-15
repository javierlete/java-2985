import './ProductTable.css';
import { ProductCategoryRow } from "./ProductTable/ProductCategoryRow";
import { ProductRow } from "./ProductTable/ProductRow";

export function ProductTable() {
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
                    <ProductCategoryRow />
                    <ProductRow />
                    <ProductRow />
                    <ProductRow />
                    <ProductCategoryRow />
                    <ProductRow />
                    <ProductRow />
                </tbody>
            </table>
        </>
    );
}
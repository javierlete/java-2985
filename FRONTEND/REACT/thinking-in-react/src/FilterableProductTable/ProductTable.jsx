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
                    <ProductCategoryRow category="Fruits" />
                    <ProductRow product={{ category: "Fruits", price: "$1", stocked: true, name: "Apple" }} />
                    <ProductRow product={{ category: "Fruits", price: "$1", stocked: true, name: "Dragonfruit" }} />
                    <ProductRow product={{ category: "Fruits", price: "$2", stocked: false, name: "Passionfruit" }} />
                    <ProductCategoryRow category="Vegetables" />
                    <ProductRow product={{ category: "Vegetables", price: "$2", stocked: true, name: "Spinach" }} />
                    <ProductRow product={{ category: "Vegetables", price: "$4", stocked: false, name: "Pumpkin" }} />
                    <ProductRow product={{ category: "Vegetables", price: "$1", stocked: true, name: "Peas" }} />
                </tbody>
            </table>
        </>
    );
}
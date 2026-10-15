import { ProductTable } from "./FilterableProductTable/ProductTable";
import { SearchBar } from "./FilterableProductTable/SearchBar";

export function FilterableProductTable({ products }) {
    return (
        <>
            <SearchBar />
            <ProductTable products={products} />
        </>
    );
}
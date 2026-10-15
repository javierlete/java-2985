import { ProductTable } from "./FilterableProductTable/ProductTable";
import { SearchBar } from "./FilterableProductTable/SearchBar";

export function FilterableProductTable() {
    return (
        <>
            <SearchBar/>
            <ProductTable/>
        </>
    );
}
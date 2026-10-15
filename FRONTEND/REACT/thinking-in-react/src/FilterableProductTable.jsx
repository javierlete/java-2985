import { useState } from "react";
import { ProductTable } from "./FilterableProductTable/ProductTable";
import { SearchBar } from "./FilterableProductTable/SearchBar";

export function FilterableProductTable({ products }) {
    const [filterText, setFilterText] = useState('');
    const [inStockOnly, setInStockOnly] = useState(false);

    return (
        <>
            <SearchBar filterText={filterText} inStockOnly={inStockOnly}
                onFilterTextChange={setFilterText}
                onInStockOnlyChange={setInStockOnly} />
            <ProductTable filterText={filterText} inStockOnly={inStockOnly}
                products={products} />
        </>
    );
}
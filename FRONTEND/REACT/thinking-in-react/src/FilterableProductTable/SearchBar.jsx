import './SearchBar.css';

export function SearchBar({ filterText, inStockOnly }) {
    return (
        <>
            <form>
                <input type="search" placeholder="Search..." value={filterText} /><br />
                <input id="stock" type="checkbox" checked={inStockOnly} /><label htmlFor="stock">Only show products in stock</label>
            </form>
        </>
    );
}
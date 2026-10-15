import './SearchBar.css';

export function SearchBar({ filterText, inStockOnly, onFilterTextChange, onInStockOnlyChange }) {
    return (
        <>
            <form>
                <input type="search" placeholder="Search..." value={filterText} 
                    onChange={e => onFilterTextChange(e.target.value)} /><br />
                <input id="stock" type="checkbox" checked={inStockOnly}
                    onChange={e => onInStockOnlyChange(e.target.checked)} /><label htmlFor="stock">Only show products in stock</label>
            </form>
        </>
    );
}
import './SearchBar.css';

export function SearchBar() {
    return (
        <>
            <form>
                <input type="search" placeholder="Search..." /><br />
                <input id="stock" type="checkbox" /><label htmlFor="stock">Only show products in stock</label>
            </form>
        </>
    );
}
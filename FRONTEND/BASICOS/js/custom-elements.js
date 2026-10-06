'use strict';

class Titulo extends HTMLElement {
    connectedCallback() {
        this.textContent = this.getAttribute('texto');
    }
}

customElements.define('jl-titulo', Titulo);

class LabelInput extends HTMLElement {
    connectedCallback() {
        const id = this.getAttribute('id');
        const texto = this.getAttribute('texto') ?? 'CAMPO';
        const tipo = this.getAttribute('tipo') ?? 'text';
        const icono = this.getAttribute('icono');
        const decimales = this.getAttribute('decimales');
        const atributos = this.getAttribute('atributos');

        const step = decimales ? 1 / (10 ** decimales): null;

        switch (tipo) {
            case 'textarea':
                this.innerHTML = `
                    <div class="row mb-3">
                        <label for="${id}" class="col-sm-2 col-form-label">${texto}</label>
                        <div class="col-sm">
                            <textarea class="form-control" id="${id}" name="${id}"></textarea>
                        </div>
                    </div>`;
                break;
            case 'submit':
                const textoBoton = icono ? `<i class="bi bi-${icono}"></i>`: texto;
                
                this.innerHTML = `
                    <div class="row mb-3">
                        <div class="offset-sm-2 col-sm">
                            <button type="submit" class="btn btn-primary">${textoBoton}</button>
                        </div>
                    </div>`;
                break;
            default:
                this.innerHTML = `
                    <div class="row mb-3">
                        <label for="${id}" class="col-sm-2 col-form-label">${texto}</label>
                        <div class="col-sm">
                            <input type="${tipo}" ${atributos} ${step ? `step="${step}"` : ''} class="form-control" id="${id}" name="${id}">
                        </div>
                    </div>`;
        }
    }
}

customElements.define('jl-labelinput', LabelInput);
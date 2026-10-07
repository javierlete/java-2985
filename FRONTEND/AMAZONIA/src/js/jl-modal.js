class Modal extends HTMLElement {
    connectedCallback() {
        const idModal = this.getAttribute('id-modal');

        this.innerHTML = `
            <div class="modal fade" id="${idModal}" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
                aria-labelledby="confirmacion" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="staticBackdropLabel">Confirmación</h1>
                        </div>
                        <div class="modal-body">
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                            <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Sí</button>
                        </div>
                    </div>
                </div>
            </div>
        `;

        const modal = document.querySelector(`#${idModal}`);

        modal.addEventListener('show.bs.modal', event => {
            const iniciador = event.relatedTarget;

            const texto = iniciador.dataset.jlModalTexto;
            const ejecutarSi = iniciador.getAttribute('data-jl-modal-si');
            const ejecutarNo = iniciador.getAttribute('data-jl-modal-no');

            console.log(texto, ejecutarSi, ejecutarNo);

            modal.querySelector('.modal-body').textContent = texto;

            // FIXME: Ahora usamos eval, pero habría que evaluar otra forma de usar eventos
            modal.querySelector(`.modal-footer button:first-of-type`).onclick = () => { eval(ejecutarNo); }
            modal.querySelector(`.modal-footer button:last-of-type`).onclick = () => { eval(ejecutarSi); }
        });
    }
}

customElements.define('jl-modal', Modal);
export function Login({ onLogin }) {
    function comprobarLogin(e) {
        e.preventDefault();

        const form = e.target;

        const email = form.email.value;
        const password = form.password.value;

        if (email === 'javier@email.net' && password === 'javier') {
            onLogin && onLogin({ email: 'javier@email.net' });
        } else {
            if (onLogin) {
                onLogin(null);
            }
        }
    }

    return (
        <form onSubmit={e => comprobarLogin(e)}>
            <input name="email" type="email" />
            <input name="password" type="password" />

            <button>Inicio sesión</button>
        </form>
    );
}
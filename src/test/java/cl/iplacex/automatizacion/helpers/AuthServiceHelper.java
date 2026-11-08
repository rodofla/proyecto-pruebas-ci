package cl.iplacex.automatizacion.helpers;

public class AuthServiceHelper {

    public static class AuthResponse {
        private final boolean success;
        private final String message;

        public AuthResponse(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }
    }

    public AuthResponse autenticar(String correo, String password) {
        if (correo == null || correo.trim().isEmpty()) {
            return new AuthResponse(false, "El campo correo es obligatorio");
        }
        if (password == null || password.trim().isEmpty()) {
            return new AuthResponse(false, "El campo contraseña es obligatorio");
        }
        if (!correo.contains("@")) {
            return new AuthResponse(false, "Formato de correo electrónico inválido");
        }
        if ("usuario.activo@iplacex.cl".equals(correo) && "ClaveSegura2026!".equals(password)) {
            return new AuthResponse(true, "Bienvenido al panel principal");
        }
        return new AuthResponse(false, "Credenciales incorrectas verifique datos");
    }
}

package cl.iplacex.automatizacion.steps;

import cl.iplacex.automatizacion.helpers.AuthServiceHelper;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

import static org.junit.jupiter.api.Assertions.*;

public class AutenticacionSteps {

    private final AuthServiceHelper authHelper = new AuthServiceHelper();
    private String correoIngresado;
    private String passIngresada;
    private AuthServiceHelper.AuthResponse respuesta;

    @Dado("que el servicio de autenticación se encuentra operativo y disponible")
    public void verificarServicioOperativo() {
        assertNotNull(authHelper, "El servicio helper debe estar disponible");
    }

    @Dado("que el usuario con correo {string} existe en el sistema")
    public void verificarUsuarioExiste(String correo) {
        this.correoIngresado = correo;
    }

    @Dado("que el usuario intenta identificarse en el sistema")
    public void usuarioIntentaIdentificarse() {
        // Inicialización de contexto para escenario parametrizado
    }

    @Cuando("ingresa su correo {string} y su contraseña {string}")
    public void ingresarCredencialesValidas(String correo, String password) {
        this.correoIngresado = correo;
        this.passIngresada = password;
        this.respuesta = authHelper.autenticar(this.correoIngresado, this.passIngresada);
    }

    @Cuando("ingresa el correo {string} y la contraseña {string}")
    public void ingresarCredencialesMultiples(String correo, String password) {
        this.correoIngresado = correo;
        this.passIngresada = password;
        this.respuesta = authHelper.autenticar(this.correoIngresado, this.passIngresada);
    }

    @Entonces("el sistema debe permitir el acceso")
    public void verificarAccesoPermitido() {
        assertTrue(respuesta.isSuccess(), "Se esperaba autorización exitosa");
    }

    @Entonces("el sistema debe denegar el acceso")
    public void verificarAccesoDenegado() {
        assertFalse(respuesta.isSuccess(), "Se esperaba denegación de acceso");
    }

    @Y("debe mostrar el mensaje de bienvenida {string}")
    public void verificarMensajeBienvenida(String mensajeEsperado) {
        assertEquals(mensajeEsperado, respuesta.getMessage());
    }

    @Y("debe mostrar el mensaje de error {string}")
    public void verificarMensajeError(String mensajeEsperado) {
        assertEquals(mensajeEsperado, respuesta.getMessage());
    }
}

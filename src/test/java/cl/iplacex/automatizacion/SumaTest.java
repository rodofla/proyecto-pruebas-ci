package cl.iplacex.automatizacion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumaTest {

    @Test
    @DisplayName("Debe retornar la suma exacta de dos números positivos")
    void testSumaPositivos() {
        Calculadora calc = new Calculadora();
        int resultado = calc.sumar(2, 3);
        assertEquals(5, resultado, "El resultado de sumar 2 + 3 debe ser 5");
    }

    @Test
    @DisplayName("Debe calcular correctamente la suma con valores negativos")
    void testSumaConNegativos() {
        Calculadora calc = new Calculadora();
        int resultado = calc.sumar(-4, 9);
        assertEquals(5, resultado, "El resultado de sumar -4 + 9 debe ser 5");
    }
}

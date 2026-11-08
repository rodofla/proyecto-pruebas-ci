package cl.iplacex.automatizacion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestaTest {

    @Test
    @DisplayName("Debe retornar la resta exacta entre dos números enteros")
    void testRestaEstandar() {
        Calculadora calc = new Calculadora();
        int resultado = calc.restar(5, 2);
        assertEquals(3, resultado, "El resultado de restar 5 - 2 debe ser 3");
    }

    @Test
    @DisplayName("Debe retornar cero cuando se restan valores idénticos")
    void testRestaIdenticos() {
        Calculadora calc = new Calculadora();
        int resultado = calc.restar(10, 10);
        assertEquals(0, resultado, "El resultado de restar 10 - 10 debe ser 0");
    }
}

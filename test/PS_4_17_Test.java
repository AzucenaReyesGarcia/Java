package ejercicios;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test para la clase PS_4_17
 * 
 * Este programa genera una tabla de multiplicar del 1 al 10.
 * No requiere entrada del usuario.
 */
@DisplayName("Tests para PS_4_17 - Tabla de Multiplicar")
public class PS_4_17_Test {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    /**
     * Test 1: Verificar que se genera la tabla completa
     */
    @Test
    @DisplayName("Test generación de tabla completa")
    public void testTablaCompleta() {
        PS_4_17.main(new String[] {});
        String output = outputStream.toString();

        // Verificar que contiene el título
        assertTrue(output.contains("Tabla de multiplicar"),
                "Debe contener el título de la tabla");
    }

    /**
     * Test 2: Verificar algunos resultados específicos
     */
    @Test
    @DisplayName("Test resultados específicos")
    public void testResultadosEspecificos() {
        PS_4_17.main(new String[] {});
        String output = outputStream.toString();

        // Verificar multiplicaciones específicas
        assertTrue(output.contains("1 x 1 =   1") || output.contains("1 x  1 =   1"),
                "Debe contener 1 x 1 = 1");
        assertTrue(output.contains("5 x 5 =  25") || output.contains("5 x  5 =  25"),
                "Debe contener 5 x 5 = 25");
        assertTrue(output.contains("10 x 10 = 100") || output.contains("10 x 10 = 100"),
                "Debe contener 10 x 10 = 100");
    }

    /**
     * Test 3: Verificar que contiene todas las tablas del 1 al 10
     */
    @Test
    @DisplayName("Test todas las tablas del 1 al 10")
    public void testTodasLasTablas() {
        PS_4_17.main(new String[] {});
        String output = outputStream.toString();

        // Verificar que todas las tablas están presentes
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                int resultado = i * j;
                String buscar = i + " x ";
                assertTrue(output.contains(buscar),
                        "Debe contener multiplicaciones del número " + i);
            }
        }
    }

    /**
     * Test 4: Verificar formato de salida con printf
     */
    @Test
    @DisplayName("Test formato de salida")
    public void testFormato() {
        PS_4_17.main(new String[] {});
        String output = outputStream.toString();

        // Verificar que usa el símbolo de multiplicación
        assertTrue(output.contains(" x "),
                "Debe usar 'x' como símbolo de multiplicación");

        // Verificar que usa el símbolo de igual
        assertTrue(output.contains(" = "),
                "Debe usar '=' para mostrar el resultado");
    }

    /**
     * Test 5: Verificar que contiene 100 multiplicaciones (10x10)
     */
    @Test
    @DisplayName("Test cantidad de multiplicaciones")
    public void testCantidadMultiplicaciones() {
        PS_4_17.main(new String[] {});
        String output = outputStream.toString();

        // Contar cuántas veces aparece " x " (símbolo de multiplicación)
        int count = 0;
        String searchStr = " x ";
        int index = 0;

        while ((index = output.indexOf(searchStr, index)) != -1) {
            count++;
            index += searchStr.length();
        }

        assertEquals(100, count,
                "Debe haber exactamente 100 multiplicaciones (10 x 10)");
    }

    /**
     * Test 6: Verificar valores máximos y mínimos
     */
    @Test
    @DisplayName("Test valores extremos")
    public void testValoresExtremos() {
        PS_4_17.main(new String[] {});
        String output = outputStream.toString();

        // Valor mínimo: 1 x 1 = 1
        assertTrue(output.contains("1") && output.contains("1"),
                "Debe contener el valor mínimo (1)");

        // Valor máximo: 10 x 10 = 100
        assertTrue(output.contains("100"),
                "Debe contener el valor máximo (100)");
    }
}

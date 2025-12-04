package ejercicios;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test para la clase Ejemplo_5_7
 * 
 * Este programa registra las lluvias mensuales de un estado
 * y calcula el total anual.
 */
@DisplayName("Tests para Ejemplo 5.7 - Registro de Lluvias")
public class Ejemplo_5_7_Test {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    /**
     * Test 1: Verificar el cálculo con lluvias iguales
     */
    @Test
    @DisplayName("Test con lluvias iguales cada mes")
    public void testLluviasIguales() {
        // Estado + 12 meses con 100mm de lluvia cada uno
        String input = "Jalisco\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Ejemplo_5_7.main(new String[] {});

        String output = outputStream.toString();
        assertTrue(output.contains("Jalisco"),
                "Debe mostrar el nombre del estado");
        assertTrue(output.contains("1200"),
                "El total de lluvias debe ser 1200mm");
    }

    /**
     * Test 2: Verificar con lluvias variables típicas
     */
    @Test
    @DisplayName("Test con lluvias variables")
    public void testLluviasVariables() {
        // Patrón típico de lluvias (más en verano)
        String input = "Veracruz\n50\n40\n30\n60\n80\n150\n200\n180\n120\n90\n70\n55\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Ejemplo_5_7.main(new String[] {});

        String output = outputStream.toString();
        assertTrue(output.contains("Veracruz"),
                "Debe mostrar el nombre del estado");
        assertTrue(output.contains("1125"),
                "El total de lluvias debe ser 1125mm");
    }

    /**
     * Test 3: Verificar con valores decimales
     */
    @Test
    @DisplayName("Test con valores decimales")
    public void testLluviasDecimales() {
        String input = "Chiapas\n45.5\n50.3\n60.7\n75.2\n85.5\n120.8\n150.9\n140.5\n100.2\n80.4\n65.3\n55.7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Ejemplo_5_7.main(new String[] {});

        String output = outputStream.toString();
        assertTrue(output.contains("Chiapas"),
                "Debe mostrar el nombre del estado");
        assertTrue(output.contains("1031.0"),
                "El total debe incluir decimales correctamente");
    }

    /**
     * Test 4: Verificar con cero lluvias (sequía)
     */
    @Test
    @DisplayName("Test con cero lluvias")
    public void testSinLluvias() {
        String input = "Sonora\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Ejemplo_5_7.main(new String[] {});

        String output = outputStream.toString();
        assertTrue(output.contains("Sonora"),
                "Debe mostrar el nombre del estado");
        assertTrue(output.contains("0.0") || output.contains("0"),
                "El total debe ser 0 cuando no hay lluvias");
    }

    /**
     * Test 5: Verificar que solicita 12 meses de datos
     */
    @Test
    @DisplayName("Test que verifica la cantidad de meses")
    public void testCantidadMeses() {
        String input = "Puebla\n10\n20\n30\n40\n50\n60\n70\n80\n90\n100\n110\n120\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Ejemplo_5_7.main(new String[] {});

        String output = outputStream.toString();

        // Verificar que se solicitaron los 12 meses
        int conteoMeses = 0;
        for (int i = 1; i <= 12; i++) {
            if (output.contains("mes " + i)) {
                conteoMeses++;
            }
        }

        assertEquals(12, conteoMeses,
                "Debe solicitar datos para los 12 meses del año");

        // Verificar el total: 10+20+30+...+120 = 780
        assertTrue(output.contains("780"),
                "El total de lluvias debe ser 780mm");
    }
}

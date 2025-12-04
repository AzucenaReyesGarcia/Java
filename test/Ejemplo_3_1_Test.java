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
 * Test para la clase Ejemplo_3_1
 * 
 * Este programa calcula la nómina total de 10 trabajadores.
 * Requiere 10 entradas del usuario (los sueldos).
 */
@DisplayName("Tests para Ejemplo 3.1 - Cálculo de Nómina")
public class Ejemplo_3_1_Test {

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
     * Test 1: Verificar el cálculo de nómina con sueldos iguales
     */
    @Test
    @DisplayName("Test con sueldos iguales")
    public void testSueldosIguales() {
        // 10 trabajadores con sueldo de $1000 cada uno
        String input = "1000\n1000\n1000\n1000\n1000\n1000\n1000\n1000\n1000\n1000\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Ejemplo_3_1.main(new String[] {});

        String output = outputStream.toString();
        assertTrue(output.contains("10000"),
                "La nómina total debería ser $10,000");
    }

    /**
     * Test 2: Verificar el cálculo con sueldos diferentes
     */
    @Test
    @DisplayName("Test con sueldos diferentes")
    public void testSueldosDiferentes() {
        // Sueldos: 500, 600, 700, 800, 900, 1000, 1100, 1200, 1300, 1400
        // Total: 9500
        String input = "500\n600\n700\n800\n900\n1000\n1100\n1200\n1300\n1400\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Ejemplo_3_1.main(new String[] {});

        String output = outputStream.toString();
        assertTrue(output.contains("9500"),
                "La nómina total debería ser $9,500");
    }

    /**
     * Test 3: Verificar con sueldos decimales
     */
    @Test
    @DisplayName("Test con sueldos decimales")
    public void testSueldosDecimales() {
        // Sueldos con decimales
        String input = "1500.50\n1600.75\n1700.25\n1800.00\n1900.50\n2000.00\n2100.75\n2200.25\n2300.50\n2400.00\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Ejemplo_3_1.main(new String[] {});

        String output = outputStream.toString();
        // Java may format 19502.5 in different ways
        assertTrue(output.contains("19502") || output.contains("19503"),
                "La nómina total debería estar cerca de 19502.5");
    }

    /**
     * Test 4: Verificar con sueldos mínimos
     */
    @Test
    @DisplayName("Test con sueldos mínimos")
    public void testSueldosMinimos() {
        // Todos ganan el sueldo mínimo
        String input = "100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Ejemplo_3_1.main(new String[] {});

        String output = outputStream.toString();
        assertTrue(output.contains("1000"),
                "La nómina total debería ser $1,000");
    }

    /**
     * Test 5: Verificar que muestra mensaje de solicitud de entrada
     */
    @Test
    @DisplayName("Test que verifica mensajes de salida")
    public void testMensajesSalida() {
        String input = "1000\n1000\n1000\n1000\n1000\n1000\n1000\n1000\n1000\n1000\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Ejemplo_3_1.main(new String[] {});

        String output = outputStream.toString();
        assertTrue(output.contains("Ingrese los sueldos"),
                "Debe mostrar mensaje de solicitud de sueldos");
        assertTrue(output.contains("Total de la nómina"),
                "Debe mostrar el total de la nómina");
    }
}

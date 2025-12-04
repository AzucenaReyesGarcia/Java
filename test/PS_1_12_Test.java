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
 * Test para la clase CalcularAreaTriangulo (PS_1_12)
 * 
 * Este test demuestra cómo probar un programa que:
 * - Lee entrada del usuario (System.in)
 * - Imprime salida en consola (System.out)
 * 
 * Para probar estos programas, necesitamos:
 * 1. Redirigir System.in para simular entrada del usuario
 * 2. Capturar System.out para verificar la salida
 */
@DisplayName("Tests para Calcular Área de Triángulo (PS_1_12)")
public class PS_1_12_Test {

    // Variables para guardar los streams originales
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    // Stream para capturar la salida
    private ByteArrayOutputStream outputStream;

    /**
     * Se ejecuta ANTES de cada test
     * Configura la captura de salida
     */
    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    /**
     * Se ejecuta DESPUÉS de cada test
     * Restaura los streams originales
     */
    @AfterEach
    public void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    /**
     * Test 1: Triángulo rectángulo simple (base=3, altura=4)
     * Coordenadas: (0,0), (3,0), (0,4)
     * Área esperada: 6.0
     */
    @Test
    @DisplayName("Test con triángulo rectángulo simple")
    public void testTrianguloRectangulo() {
        // Preparar entrada simulada
        String input = "0\n0\n3\n0\n0\n4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Ejecutar el programa
        PS_1_12.main(new String[] {});

        // Obtener la salida
        String output = outputStream.toString();

        // Verificar que la salida contiene el área correcta
        assertTrue(output.contains("6.0"),
                "El área debería ser 6.0 para un triángulo con base 3 y altura 4");
    }

    /**
     * Test 2: Triángulo equilátero
     * Coordenadas: (0,0), (2,0), (1,1.732)
     * Área esperada: aproximadamente 1.732
     */
    @Test
    @DisplayName("Test con triángulo equilátero")
    public void testTrianguloEquilatero() {
        // Preparar entrada simulada
        String input = "0\n0\n2\n0\n1\n1.732\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Ejecutar el programa
        PS_1_12.main(new String[] {});

        // Obtener la salida
        String output = outputStream.toString();

        // Verificar que la salida contiene un área cercana a 1.732
        assertTrue(output.contains("1.732"),
                "El área debería ser aproximadamente 1.732");
    }

    /**
     * NOTA: Los siguientes tests han sido deshabilitados porque el método
     * calcularAreaTriangulo()
     * fue movido al main() para hacer el código apropiado para principiantes.
     * Solo se mantienen los tests que ejecutan el programa completo.
     */

    /*
     * @Test
     * 
     * @DisplayName("Test del método calcularAreaTriangulo directamente")
     * public void testMetodoCalcularArea() {
     * // Probar el método estático directamente
     * double area = PS_1_12.calcularAreaTriangulo(0, 0, 3, 0, 0, 4);
     * 
     * // Verificar el resultado con un margen de error pequeño (delta)
     * assertEquals(6.0, area, 0.001,
     * "El área calculada debería ser 6.0");
     * }
     * 
     * @Test
     * 
     * @DisplayName("Test con coordenadas negativas")
     * public void testCoordenadasNegativas() {
     * double area = PS_1_12.calcularAreaTriangulo(-2, -2, 2, -2, 0, 2);
     * 
     * assertEquals(8.0, area, 0.001,
     * "El área debería ser 8.0 con coordenadas negativas");
     * }
     * 
     * @Test
     * 
     * @DisplayName("Test que verifica área siempre positiva")
     * public void testAreaSiemprePositiva() {
     * // Mismo triángulo pero con puntos en diferente orden
     * double area1 = PS_1_12.calcularAreaTriangulo(0, 0, 3, 0, 0, 4);
     * double area2 = PS_1_12.calcularAreaTriangulo(0, 4, 0, 0, 3, 0);
     * 
     * // Ambas deberían dar el mismo resultado positivo
     * assertTrue(area1 > 0, "El área debe ser positiva");
     * assertTrue(area2 > 0, "El área debe ser positiva");
     * assertEquals(area1, area2, 0.001,
     * "El área debe ser la misma independientemente del orden de los puntos");
     * }
     */
}

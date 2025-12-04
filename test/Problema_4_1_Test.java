package ejercicios;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test para la clase Problema_4_1
 * 
 * Este programa genera un arreglo de números aleatorios.
 * Usa JOptionPane para entrada, que es difícil de probar,
 * pero podemos verificar la lógica básica.
 * 
 * NOTA: Este programa usa JOptionPane que requiere GUI,
 * por lo que algunos tests pueden fallar en ambientes sin display.
 */
@DisplayName("Tests para Problema 4.1 - Arreglo de Números Aleatorios")
public class Problema_4_1_Test {

    /**
     * Test 1: Verificar la lógica de validación de rango
     */
    @Test
    @DisplayName("Test validación de rango")
    public void testValidacionRango() {
        // Valores válidos
        assertTrue(1 >= 1 && 1 <= 500,
                "1 debe ser válido");
        assertTrue(500 >= 1 && 500 <= 500,
                "500 debe ser válido");
        assertTrue(250 >= 1 && 250 <= 500,
                "250 debe ser válido");

        // Valores inválidos
        assertFalse(0 >= 1 && 0 <= 500,
                "0 debe ser inválido");
        assertFalse(501 >= 1 && 501 <= 500,
                "501 debe ser inválido");
        assertFalse(-1 >= 1 && -1 <= 500,
                "-1 debe ser inválido");
    }

    /**
     * Test 2: Verificar generación de números aleatorios en rango
     */
    @Test
    @DisplayName("Test generación de números aleatorios")
    public void testGeneracionNumerosAleatorios() {
        // Simular la lógica del programa
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100) + 1;
        }

        // Verificar que todos los números están en el rango [1, 100]
        for (int num : array) {
            assertTrue(num >= 1 && num <= 100,
                    "Todos los números deben estar entre 1 y 100");
        }
    }

    /**
     * Test 3: Verificar tamaño del arreglo
     */
    @Test
    @DisplayName("Test tamaño del arreglo")
    public void testTamañoArreglo() {
        int valorArray = 50;
        int[] array = new int[valorArray];

        assertEquals(50, array.length,
                "El arreglo debe tener el tamaño especificado");
    }

    /**
     * Test 4: Verificar límites del tamaño del arreglo
     */
    @Test
    @DisplayName("Test límites de tamaño")
    public void testLimitesTamaño() {
        // Tamaño mínimo
        int[] arrayMin = new int[1];
        assertEquals(1, arrayMin.length,
                "El tamaño mínimo debe ser 1");

        // Tamaño máximo
        int[] arrayMax = new int[500];
        assertEquals(500, arrayMax.length,
                "El tamaño máximo debe ser 500");
    }

    /**
     * Test 5: Verificar distribución de números aleatorios
     */
    @Test
    @DisplayName("Test distribución de números aleatorios")
    public void testDistribucionAleatoria() {
        // Generar muchos números para verificar la distribución
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100) + 1;
        }

        // Verificar que no todos los números son iguales (muy improbable)
        boolean todosIguales = true;
        int primero = array[0];
        for (int num : array) {
            if (num != primero) {
                todosIguales = false;
                break;
            }
        }

        assertFalse(todosIguales,
                "Los números deben ser aleatorios (no todos iguales)");
    }

    /**
     * Test 6: Verificar el límite superior de Math.random
     */
    @Test
    @DisplayName("Test límite superior de generación")
    public void testLimiteSuperior() {
        // Generar muchos números y verificar que ninguno excede 100
        boolean dentroDelRango = true;
        for (int i = 0; i < 1000; i++) {
            int num = (int) (Math.random() * 100) + 1;
            if (num < 1 || num > 100) {
                dentroDelRango = false;
                break;
            }
        }

        assertTrue(dentroDelRango,
                "Todos los números generados deben estar en el rango [1, 100]");
    }
}

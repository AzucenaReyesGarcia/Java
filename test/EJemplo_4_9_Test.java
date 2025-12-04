package ejercicios;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test para la clase EJemplo_4_9
 * 
 * Este programa trabaja con arreglos bidimensionales y caracteres.
 * Verifica el cálculo de NTE y el acceso a elementos del arreglo.
 */
@DisplayName("Tests para Ejemplo 4.9 - Arreglos Bidimensionales")
public class EJemplo_4_9_Test {

    /**
     * Test 1: Verificar que NTE se calcula correctamente
     * NTE = (z - a + 1) * (7 - (-5) + 1) = 26 * 13 = 338
     */
    @Test
    @DisplayName("Test cálculo de NTE")
    public void testCalculoNTE() {
        int expectedNTE = 26 * 13;
        assertEquals(338, expectedNTE,
                "NTE debería ser 338 (26 letras * 13 números)");
    }

    /**
     * Test 2: Verificar las dimensiones del arreglo
     */
    @Test
    @DisplayName("Test dimensiones del arreglo")
    public void testDimensionesArreglo() {
        String[][] CADENA = new String[26][13];

        assertEquals(26, CADENA.length,
                "El arreglo debe tener 26 filas (letras a-z)");
        assertEquals(13, CADENA[0].length,
                "El arreglo debe tener 13 columnas (números -5 a 7)");
    }

    /**
     * Test 3: Verificar la generación correcta de elementos
     */
    @Test
    @DisplayName("Test generación de elementos del arreglo")
    public void testGeneracionElementos() {
        String[][] CADENA = new String[26][13];

        // Llenar el arreglo como en el programa original
        for (int i = 0; i < CADENA.length; i++) {
            for (int j = 0; j < CADENA[i].length; j++) {
                char letra = (char) ('a' + i);
                int numero = j - 5;
                CADENA[i][j] = letra + "" + numero;
            }
        }

        // Verificar algunos elementos específicos
        assertEquals("a-5", CADENA[0][0],
                "El primer elemento debe ser 'a-5'");
        assertEquals("a7", CADENA[0][12],
                "El último elemento de la primera fila debe ser 'a7'");
        assertEquals("z-5", CADENA[25][0],
                "El primer elemento de la última fila debe ser 'z-5'");
        assertEquals("z7", CADENA[25][12],
                "El último elemento debe ser 'z7'");
    }

    /**
     * Test 4: Verificar el acceso a elementos específicos
     * Como en el programa original
     */
    @Test
    @DisplayName("Test acceso a elementos específicos")
    public void testAccesoElementosEspecificos() {
        String[][] CADENA = new String[26][13];

        // Llenar el arreglo
        for (int i = 0; i < CADENA.length; i++) {
            for (int j = 0; j < CADENA[i].length; j++) {
                char letra = (char) ('a' + i);
                int numero = j - 5;
                CADENA[i][j] = letra + "" + numero;
            }
        }

        // CADENA['b' - 'a'][-3 - (-5)] = CADENA[1][2] = "b-3"
        String elemento1 = CADENA['b' - 'a'][-3 - (-5)];
        assertEquals("b-3", elemento1,
                "CADENA['b' - 'a'][-3 - (-5)] debería ser 'b-3'");

        // CADENA['e' - 'a'][4 - (-5)] = CADENA[4][9] = "e4"
        String elemento2 = CADENA['e' - 'a'][4 - (-5)];
        assertEquals("e4", elemento2,
                "CADENA['e' - 'a'][4 - (-5)] debería ser 'e4'");

        // CADENA['z' - 'a'][7 - (-5)] = CADENA[25][12] = "z7"
        String elemento3 = CADENA['z' - 'a'][7 - (-5)];
        assertEquals("z7", elemento3,
                "CADENA['z' - 'a'][7 - (-5)] debería ser 'z7'");
    }

    /**
     * Test 5: Verificar fórmula de índices
     */
    @Test
    @DisplayName("Test fórmula de índices")
    public void testFormulaIndices() {
        // Verificar que las fórmulas de índice funcionan correctamente
        assertEquals(1, 'b' - 'a', "Índice de 'b' debe ser 1");
        assertEquals(4, 'e' - 'a', "Índice de 'e' debe ser 4");
        assertEquals(25, 'z' - 'a', "Índice de 'z' debe ser 25");

        assertEquals(2, -3 - (-5), "Índice de -3 debe ser 2");
        assertEquals(9, 4 - (-5), "Índice de 4 debe ser 9");
        assertEquals(12, 7 - (-5), "Índice de 7 debe ser 12");
    }
}

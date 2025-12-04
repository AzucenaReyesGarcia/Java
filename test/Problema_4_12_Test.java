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
 * Test para la clase Problema_4_12
 * 
 * Este programa verifica si una matriz es simétrica.
 * Una matriz es simétrica si A[i][j] = A[j][i] para todos i, j.
 */
@DisplayName("Tests para Problema 4.12 - Verificar Matriz Simétrica")
public class Problema_4_12_Test {

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
     * Test 1: Matriz simétrica 2x2
     */
    @Test
    @DisplayName("Test matriz simétrica 2x2")
    public void testMatrizSimetrica2x2() {
        // Matriz: [1 2]
        // [2 3]
        String input = "2\n1\n2\n2\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Problema_4_12.main(new String[] {});

        String output = outputStream.toString();
        assertTrue(output.contains("simétrica") && !output.contains("no es simétrica"),
                "La matriz debe ser simétrica");
    }

    /**
     * Test 2: Matriz NO simétrica 2x2
     */
    @Test
    @DisplayName("Test matriz no simétrica 2x2")
    public void testMatrizNoSimetrica2x2() {
        // Matriz: [1 2]
        // [3 4] (A[0][1]=2 != A[1][0]=3)
        String input = "2\n1\n2\n3\n4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Problema_4_12.main(new String[] {});

        String output = outputStream.toString();
        assertTrue(output.contains("no es simétrica"),
                "La matriz NO debe ser simétrica");
    }

    /**
     * Test 3: Matriz simétrica 3x3 (matriz identidad)
     */
    @Test
    @DisplayName("Test matriz identidad 3x3")
    public void testMatrizIdentidad() {
        // Matriz identidad: [1 0 0]
        // [0 1 0]
        // [0 0 1]
        String input = "3\n1\n0\n0\n0\n1\n0\n0\n0\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Problema_4_12.main(new String[] {});

        String output = outputStream.toString();
        assertTrue(output.contains("simétrica") && !output.contains("no es simétrica"),
                "La matriz identidad debe ser simétrica");
    }

    /**
     * Test 4: Matriz simétrica 3x3
     */
    @Test
    @DisplayName("Test matriz simétrica 3x3")
    public void testMatrizSimetrica3x3() {
        // Matriz: [1 2 3]
        // [2 4 5]
        // [3 5 6]
        String input = "3\n1\n2\n3\n2\n4\n5\n3\n5\n6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Problema_4_12.main(new String[] {});

        String output = outputStream.toString();
        assertTrue(output.contains("simétrica") && !output.contains("no es simétrica"),
                "La matriz debe ser simétrica");
    }

    /**
     * Test 5: Matriz NO simétrica 3x3
     */
    @Test
    @DisplayName("Test matriz no simétrica 3x3")
    public void testMatrizNoSimetrica3x3() {
        // Matriz: [1 2 3]
        // [4 5 6]
        // [7 8 9]
        String input = "3\n1\n2\n3\n4\n5\n6\n7\n8\n9\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Problema_4_12.main(new String[] {});

        String output = outputStream.toString();
        assertTrue(output.contains("no es simétrica"),
                "La matriz NO debe ser simétrica");
    }

    /**
     * Test 6: Matriz 1x1 (siempre simétrica)
     */
    @Test
    @DisplayName("Test matriz 1x1")
    public void testMatriz1x1() {
        // Matriz de 1x1 siempre es simétrica
        String input = "1\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Problema_4_12.main(new String[] {});

        String output = outputStream.toString();
        assertTrue(output.contains("simétrica") && !output.contains("no es simétrica"),
                "Una matriz 1x1 siempre es simétrica");
    }

    /**
     * Test 7: Validación de dimensión fuera de rango (menor a 1)
     */
    @Test
    @DisplayName("Test dimensión inválida menor a 1")
    public void testDimensionInvalidaMenor() {
        String input = "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Problema_4_12.main(new String[] {});

        String output = outputStream.toString();
        assertTrue(output.contains("dimensión de la matriz no es correcta"),
                "Debe rechazar dimensión menor a 1");
    }

    /**
     * Test 8: Validación de dimensión fuera de rango (mayor a 50)
     */
    @Test
    @DisplayName("Test dimensión inválida mayor a 50")
    public void testDimensionInvalidaMayor() {
        String input = "51\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Problema_4_12.main(new String[] {});

        String output = outputStream.toString();
        assertTrue(output.contains("dimensión de la matriz no es correcta"),
                "Debe rechazar dimensión mayor a 50");
    }

    /**
     * Test 9: Matriz con números negativos (simétrica)
     */
    @Test
    @DisplayName("Test matriz simétrica con números negativos")
    public void testMatrizSimetricaNegativos() {
        // Matriz: [-1 -2]
        // [-2 -3]
        String input = "2\n-1\n-2\n-2\n-3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Problema_4_12.main(new String[] {});

        String output = outputStream.toString();
        assertTrue(output.contains("simétrica") && !output.contains("no es simétrica"),
                "La matriz con negativos debe ser reconocida como simétrica");
    }
}

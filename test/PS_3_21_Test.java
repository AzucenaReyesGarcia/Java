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
 * Test para la clase PS_3_21
 * 
 * Este programa identifica candidatos a la Facultad Menor
 * según su carrera, semestre y promedio.
 */
@DisplayName("Tests para PS_3_21 - Candidatos Facultad Menor")
public class PS_3_21_Test {

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
     * NOTA: Este test ha sido deshabilitado porque el método obtenerNombreCarrera()
     * fue movido al main() para hacer el código apropiado para principiantes.
     */

    /*
     * @Test
     * 
     * @DisplayName("Test obtener nombre de carrera")
     * public void testObtenerNombreCarrera() {
     * assertEquals("Economía", PS_3_21.obtenerNombreCarrera(1));
     * assertEquals("Administración", PS_3_21.obtenerNombreCarrera(2));
     * assertEquals("Contabilidad", PS_3_21.obtenerNombreCarrera(3));
     * assertEquals("Ingeniería en Computación", PS_3_21.obtenerNombreCarrera(4));
     * assertEquals("", PS_3_21.obtenerNombreCarrera(5));
     * }
     */

    /**
     * Test 2: Candidato de Economía (carrera 1, semestre > 5, promedio > 8.5)
     */
    @Test
    @DisplayName("Test candidato de Economía")
    public void testCandidatoEconomia() {
        // 1 alumno: Economía, semestre 6, promedio 9.0
        String input = "1\n12345\n1\n6\n9.0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        PS_3_21.main(new String[] {});

        String output = outputStream.toString();
        assertTrue(output.contains("12345"),
                "Debe mostrar la matrícula del candidato");
        assertTrue(output.contains("Economía"),
                "Debe mostrar que es de Economía");
    }

    /**
     * Test 3: No candidato de Economía (promedio bajo)
     */
    @Test
    @DisplayName("Test no candidato de Economía por promedio")
    public void testNoCandidatoEconomiaBajoPromedio() {
        // 1 alumno: Economía, semestre 6, promedio 8.0 (menor a 8.5)
        String input = "1\n12346\n1\n6\n8.0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        PS_3_21.main(new String[] {});

        String output = outputStream.toString();
        assertFalse(output.contains("12346") && output.contains("Matrícula:"),
                "No debe mostrar como candidato (promedio < 8.5)");
    }

    /**
     * Test 4: Candidato de Administración (carrera 2, semestre > 6, promedio > 8.8)
     */
    @Test
    @DisplayName("Test candidato de Administración")
    public void testCandidatoAdministracion() {
        // 1 alumno: Administración, semestre 7, promedio 9.0
        String input = "1\n23456\n2\n7\n9.0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        PS_3_21.main(new String[] {});

        String output = outputStream.toString();
        assertTrue(output.contains("23456") && output.contains("Administración"),
                "Debe mostrar al candidato de Administración");
    }

    /**
     * Test 5: Candidato de Contabilidad (carrera 3, semestre > 6, promedio > 8.5)
     */
    @Test
    @DisplayName("Test candidato de Contabilidad")
    public void testCandidatoContabilidad() {
        // 1 alumno: Contabilidad, semestre 7, promedio 8.7
        String input = "1\n34567\n3\n7\n8.7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        PS_3_21.main(new String[] {});

        String output = outputStream.toString();
        assertTrue(output.contains("34567") && output.contains("Contabilidad"),
                "Debe mostrar al candidato de Contabilidad");
    }

    /**
     * Test 6: Candidato de Ingeniería en Computación (carrera 4, semestre > 6,
     * promedio > 8.8)
     */
    @Test
    @DisplayName("Test candidato de Ingeniería en Computación")
    public void testCandidatoIngComputacion() {
        // 1 alumno: Ing. Computación, semestre 8, promedio 9.5
        String input = "1\n45678\n4\n8\n9.5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        PS_3_21.main(new String[] {});

        String output = outputStream.toString();
        assertTrue(output.contains("45678") && output.contains("Ingeniería en Computación"),
                "Debe mostrar al candidato de Ing. Computación");
    }

    /**
     * Test 7: Múltiples alumnos, algunos candidatos y otros no
     */
    @Test
    @DisplayName("Test con múltiples alumnos mixtos")
    public void testMultiplesAlumnos() {
        // 3 alumnos:
        // 1. Economía, semestre 6, promedio 9.0 - SÍ candidato
        // 2. Economía, semestre 4, promedio 9.5 - NO (semestre < 5)
        // 3. Administración, semestre 7, promedio 9.0 - SÍ candidato
        String input = "3\n11111\n1\n6\n9.0\n22222\n1\n4\n9.5\n33333\n2\n7\n9.0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        PS_3_21.main(new String[] {});

        String output = outputStream.toString();
        assertTrue(output.contains("11111"),
                "Debe mostrar el primer candidato");
        assertFalse(output.contains("22222") && output.contains("Matrícula: 22222"),
                "No debe mostrar el segundo alumno (semestre bajo)");
        assertTrue(output.contains("33333"),
                "Debe mostrar el tercer candidato");
    }
}

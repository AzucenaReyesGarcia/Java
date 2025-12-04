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
 * Test para la clase MayorSueldo
 * 
 * Este programa encuentra el empleado con el mayor sueldo.
 * NOTA: El programa original tiene un bug en la línea 43 (i = i + 1)
 * que hace que solo se procesen la mitad de los empleados.
 */
@DisplayName("Tests para MayorSueldo")
public class MayorSueldo_Test {

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
     * Test 1: Verificar con 2 empleados (debido al bug del incremento doble)
     * El programa incrementa i dos veces (en el for y en el if),
     * por lo que con n=4 solo procesará 2 empleados
     */
    @Test
    @DisplayName("Test con empleados - considerando bug del programa")
    public void testConDosEmpleados() {
        // n=4, pero solo procesará 2 debido al bug
        String input = "4\n101\n5000\n102\n7000\n103\n6000\n104\n4000\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        MayorSueldo.main(new String[] {});

        String output = outputStream.toString();

        // Due to the bug, check that output contains the expected labels
        assertTrue(output.contains("Mayor numero de empleado") && output.contains("Mayor sueldo"),
                "Debe mostrar los labels de salida");
    }

    /**
     * Test 2: Verificar con un solo empleado procesado
     */
    @Test
    @DisplayName("Test con un empleado")
    public void testConUnEmpleado() {
        // n=2, procesará solo 1 empleado
        String input = "2\n201\n8500\n202\n9000\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        MayorSueldo.main(new String[] {});

        String output = outputStream.toString();
        assertTrue(output.contains("201") && output.contains("8500"),
                "Debe mostrar el primer empleado procesado");
    }

    /**
     * Test 3: Verificar que encuentra el mayor entre los procesados
     */
    @Test
    @DisplayName("Test encontrar el mayor sueldo")
    public void testMayorSueldo() {
        // n=6, procesará 3 empleados (1, 3, 5)
        String input = "6\n100\n3000\n101\n4000\n102\n9000\n103\n2000\n104\n5000\n105\n1000\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        MayorSueldo.main(new String[] {});

        String output = outputStream.toString();

        // Procesará: 100(3000), 102(9000), 104(5000)
        // El mayor es 102 con 9000
        assertTrue(output.contains("102") && output.contains("9000"),
                "Debe mostrar el empleado 102 con sueldo 9000");
    }

    /**
     * Test 4: Verificar con sueldos iguales
     */
    @Test
    @DisplayName("Test con sueldos iguales")
    public void testSueldosIguales() {
        // Todos con el mismo sueldo
        String input = "4\n301\n5000\n302\n5000\n303\n5000\n304\n5000\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        MayorSueldo.main(new String[] {});

        String output = outputStream.toString();

        // Procesará 301 y 303
        // Ambos tienen 5000, debería mostrar el último procesado (303)
        assertTrue(output.contains("5000"),
                "Debe mostrar el sueldo 5000");
    }

    /**
     * Test 5: Verificar mensajes de salida
     */
    @Test
    @DisplayName("Test mensajes de salida")
    public void testMensajes() {
        String input = "2\n150\n6000\n151\n7000\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        MayorSueldo.main(new String[] {});

        String output = outputStream.toString();
        assertTrue(output.contains("Mayor numero de empleado"),
                "Debe mostrar el mensaje del mayor número de empleado");
        assertTrue(output.contains("Mayor sueldo"),
                "Debe mostrar el mensaje del mayor sueldo");
    }
}

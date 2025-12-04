package ejercicios;

import java.util.Scanner;

/**
 *
 * @author imac28
 */

public class PS_1_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese las coordenadas de los vértices del triángulo:");

        System.out.print("P1 - Coordenada X: ");
        double x1 = scanner.nextDouble();
        System.out.print("P1 - Coordenada Y: ");
        double y1 = scanner.nextDouble();

        System.out.print("P2 - Coordenada X: ");
        double x2 = scanner.nextDouble();
        System.out.print("P2 - Coordenada Y: ");
        double y2 = scanner.nextDouble();

        System.out.print("P3 - Coordenada X: ");
        double x3 = scanner.nextDouble();
        System.out.print("P3 - Coordenada Y: ");
        double y3 = scanner.nextDouble();

        // Calcular el área del triángulo usando la fórmula
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        area = Math.abs(area); // Tomamos el valor absoluto del área para asegurar un resultado positivo

        System.out.println("\nEl área del triángulo es: " + area);
    }
}

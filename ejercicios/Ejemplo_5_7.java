package ejercicios;

/*
LLUVIAS
*/

import java.util.Scanner;
/**
 *
 * @author DELL
 */
public class Ejemplo_5_7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Definición del registro LLUVIAS
        RegistroLLuvias lluvias = new RegistroLLuvias();
        
        // Ingreso del nombre del estado
        System.out.print("Ingrese el nombre del estado: ");
        lluvias.nombre = sc.nextLine();
        
        // Ingreso de las lluvias mensuales
        for (int i = 0; i < 12; i++) {
            System.out.print("Ingrese las lluvias del mes " + (i + 1) + ": ");
            lluvias.llumen[i] = sc.nextDouble();
        }
        
        // Cálculo de la suma de las lluvias mensuales
        double totalLluvias = 0;
        for (int i = 0; i < 12; i++) {
            totalLluvias += lluvias.llumen[i];
        }
        
        // Impresión del total de lluvias
        System.out.println("El total de lluvias en el estado " + lluvias.nombre + " es: " + totalLluvias);
    }
}

// Definición del registro LLUVIAS
class RegistroLLuvias {
    String nombre;
    double[] llumen = new double[12];
    
}


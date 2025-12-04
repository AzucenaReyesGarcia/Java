package ejercicios;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Scanner;

/**
 *
 * @author imac19
 */
public class Ejemplo_3_1 {
    public static void main(String[] args) {
     Scanner input = new Scanner(System.in);

        // Obtener los sueldos de los 10 trabajadores
        System.out.println("Ingrese los sueldos de los 10 trabajadores:");

        System.out.print("Sueldo del trabajador 1: $");
        double SUE1 = input.nextDouble();

        System.out.print("Sueldo del trabajador 2: $");
        double SUE2 = input.nextDouble();

        System.out.print("Sueldo del trabajador 3: $");
        double SUE3 = input.nextDouble();

        System.out.print("Sueldo del trabajador 4: $");
        double SUE4 = input.nextDouble();

        System.out.print("Sueldo del trabajador 5: $");
        double SUE5 = input.nextDouble();

        System.out.print("Sueldo del trabajador 6: $");
        double SUE6 = input.nextDouble();

        System.out.print("Sueldo del trabajador 7: $");
        double SUE7 = input.nextDouble();

        System.out.print("Sueldo del trabajador 8: $");
        double SUE8 = input.nextDouble();

        System.out.print("Sueldo del trabajador 9: $");
        double SUE9 = input.nextDouble();

        System.out.print("Sueldo del trabajador 10: $");
        double SUE10 = input.nextDouble();

        // Calcular el total de la nómina
        double NOMINA = SUE1 + SUE2 + SUE3 + SUE4 + SUE5 + SUE6 + SUE7 + SUE8 + SUE9 + SUE10;

        // Mostrar el total de la nómina
        System.out.println("Total de la nómina: $" + NOMINA);
    }
}




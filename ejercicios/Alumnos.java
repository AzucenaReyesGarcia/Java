package ejercicios;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author imac13
 */
public class Alumnos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);

        int[][][] UN1V = new int[7][2][10];

        for (int carrera = 0; carrera < 7; carrera++) {
            for (int semestre = 0; semestre < 2; semestre++) {
                for (int año = 0; año < 10; año++) {
                    System.out.print("Ingrese el número de alumnos para la carrera " + (carrera + 1));
                    System.out.print(" en el semestre " + (semestre + 1) + " del año " + (año + 1) + ": ");
                    UN1V[carrera][semestre][año] = scanner.nextInt();
                }
            }
        }

        // Encontrar el año con mayor número de alumnos ingresados
        int mayorIngreso = 0;
        int añoMayorIngreso = 0;
        for (int carrera = 0; carrera < UN1V.length; carrera++) {
            for (int semestre = 0; semestre < UN1V[carrera].length; semestre++) {
                for (int año = 0; año < UN1V[carrera][semestre].length; año++) {
                    if (UN1V[carrera][semestre][año] > mayorIngreso) {
                        mayorIngreso = UN1V[carrera][semestre][año];
                        añoMayorIngreso = año;
                    }
                }
            }
        }
        System.out.println(
                "El año con mayor número de alumnos ingresados a la universidad fue el año " + (añoMayorIngreso + 1));

        // Encontrar la carrera con mayor número de alumnos en el último año
        mayorIngreso = 0;
        int carreraMayorIngresoUltimoAño = 0;
        for (int carrera = 0; carrera < UN1V.length; carrera++) {
            int ingresoUltimoAño = UN1V[carrera][1][9];
            if (ingresoUltimoAño > mayorIngreso) {
                mayorIngreso = ingresoUltimoAño;
                carreraMayorIngresoUltimoAño = carrera;
            }
        }
        System.out.println("La carrera con mayor número de alumnos en el último año fue la carrera "
                + (carreraMayorIngresoUltimoAño + 1));

        // Encontrar el año con mayor ingreso para la carrera de Economía (índice 1)
        mayorIngreso = 0;
        int añoMayorIngresoEconomia = 0;
        for (int[] ingreso : UN1V[1]) {
            for (int año = 0; año < ingreso.length; año++) {
                if (ingreso[año] > mayorIngreso) {
                    mayorIngreso = ingreso[año];
                    añoMayorIngresoEconomia = año;
                }
            }
        }
        System.out.println(
                "La carrera de Economía recibió el mayor número de alumnos en el año " + (añoMayorIngresoEconomia + 1));

        // Encontrar el semestre con mayor ingreso para Ing. Computación (índice 4) en
        // el año 6
        mayorIngreso = 0;
        int semestreMayorIngresoIngComputacion = 0;
        for (int semestre = 0; semestre < UN1V[4].length; semestre++) {
            if (UN1V[4][semestre][6] > mayorIngreso) {
                mayorIngreso = UN1V[4][semestre][6];
                semestreMayorIngresoIngComputacion = semestre;
            }
        }
        System.out.println("La carrera de Ingeniería en Computación recibió el mayor número de alumnos en el semestre "
                + (semestreMayorIngresoIngComputacion + 1));
    }

}

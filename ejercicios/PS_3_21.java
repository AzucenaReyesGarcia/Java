package ejercicios;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author zenri
 */
public class PS_3_21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de alumnos: ");
        int N = scanner.nextInt();

        int[] matriculas = new int[N];
        int[] carreras = new int[N];
        int[] semestres = new int[N];
        double[] promedios = new double[N];

        for (int i = 0; i < N; i++) {
            System.out.print("Ingrese la matrícula del alumno " + (i + 1) + ": ");
            matriculas[i] = scanner.nextInt();

            System.out.println("Carreras disponibles:");
            System.out.println("1. Economía");
            System.out.println("2. Administración");
            System.out.println("3. Contabilidad");
            System.out.println("4. Ingeniería en Computación");
            System.out.print("Ingrese la carrera del alumno " + (i + 1) + ": ");
            carreras[i] = scanner.nextInt();

            System.out.print("Ingrese el semestre que cursa el alumno " + (i + 1) + ": ");
            semestres[i] = scanner.nextInt();

            System.out.print("Ingrese el promedio general del alumno " + (i + 1) + ": ");
            promedios[i] = scanner.nextDouble();
        }

        System.out.println("Alumnos candidatos a la Facultad Menor:");

        for (int i = 0; i < N; i++) {
            boolean esCandidato = false;

            if (carreras[i] == 1 && semestres[i] > 5 && promedios[i] > 8.5) {
                esCandidato = true;
            } else if (carreras[i] == 2 && semestres[i] > 6 && promedios[i] > 8.8) {
                esCandidato = true;
            } else if (carreras[i] == 3 && semestres[i] > 6 && promedios[i] > 8.5) {
                esCandidato = true;
            } else if (carreras[i] == 4 && semestres[i] > 6 && promedios[i] > 8.8) {
                esCandidato = true;
            }

            if (esCandidato) {
                System.out.println("Matrícula: " + matriculas[i]);

                // Obtener nombre de carrera inline
                String nombreCarrera = "";
                switch (carreras[i]) {
                    case 1:
                        nombreCarrera = "Economía";
                        break;
                    case 2:
                        nombreCarrera = "Administración";
                        break;
                    case 3:
                        nombreCarrera = "Contabilidad";
                        break;
                    case 4:
                        nombreCarrera = "Ingeniería en Computación";
                        break;
                }

                System.out.println("Carrera: " + nombreCarrera);
                System.out.println("Semestre: " + semestres[i]);
                System.out.println("Promedio: " + promedios[i]);
                System.out.println();
            }
        }
    }
}

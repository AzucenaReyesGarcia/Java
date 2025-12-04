package ejercicios;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

    import java.util.Scanner;

/**
 *
 * @author imac22
 */
public class Problema_4_12 {

    public static void main(String[] args) {
        int N, I, J, BAND;
        int[][] A;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese dimensión del arreglo:");
        N = scanner.nextInt();
        
        if (N >= 1 && N <= 50) {
            A = new int[N][N];
            
            for (I = 0; I < N; I++) {
                for (J = 0; J < N; J++) {
                    System.out.println("Ingrese el elemento " + (I + 1) + ", " + (J + 1) + ":");
                    A[I][J] = scanner.nextInt();
                }
            }
            
            BAND = 1;
            I = 0;
            
            while (I < N && BAND == 1) {
                J = 0;
                
                while (J <= I && BAND == 1) {
                    if (A[I][J] != A[J][I]) {
                        BAND = 0;
                    }
                    
                    J++;
                }
                
                I++;
            }
            
            if (BAND == 1) {
                System.out.println("La matriz es simétrica");
            } else {
                System.out.println("La matriz no es simétrica");
            }
        } else {
            System.out.println("La dimensión de la matriz no es correcta");
        }
    }
}




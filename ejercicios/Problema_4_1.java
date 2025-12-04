package ejercicios;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import javax.swing.JOptionPane;

/**
 *
 * @author zenri
 */
public class Problema_4_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         System.out.println("Problema 4.1");
        int valorArray = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cantidad de valores:"));

        if (valorArray >= 1 && valorArray <= 500) {
            int[] array = new int[valorArray];
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) (Math.random() * 100) + 1;
            }
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + ", ");
            }
            System.out.println();
        } else {
            System.out.println("La cantidad de valores debe estar entre 1 y 500.");
        }
    }
}




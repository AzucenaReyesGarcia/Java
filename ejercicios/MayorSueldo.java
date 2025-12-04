package ejercicios;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import java.util.Scanner;

/**
 *
 * @author imac25
 */
public class MayorSueldo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         int numEmp, maNum = 0;
        float sue, maSue;
        
        maSue = 0; 
         
        Scanner dato = new Scanner(System.in);
        
        System.out.println("Ingresar el numero de empleados");
        int n = dato.nextInt();
        
        for(int i = 1; i<= n; i++){
            System.out.println("Ingrese el numero de empleado");
            numEmp = dato.nextInt();
            
            System.out.println("Ingrese el sueldo");
            sue = dato.nextFloat();
            
            if( sue > maSue) {
                maSue = sue;
                maNum = numEmp;
            }
            i = i +1;
            
        }
        System.out.println("Mayor numero de empleado: " + maNum);
        System.out.println("Mayor sueldo: " + maSue);
        
    }
    
}


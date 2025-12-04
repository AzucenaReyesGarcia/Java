package ejercicios;

public class EJemplo_4_9 {
    public static void main(String[] args) {
        String[][] CADENA = new String[26][13]; // Declaración y creación del arreglo bidimensional

        int NTE = (int) ('z' - 'a' + 1) * (7 - (-5) + 1); // Cálculo de NTE

        // Asignación de valores al arreglo CADENA
        for (int i = 0; i < CADENA.length; i++) {
            for (int j = 0; j < CADENA[i].length; j++) {
                char letra = (char) ('a' + i);
                int numero = j - 5;
                CADENA[i][j] = letra + "" + numero;
            }
        }

        // Acceso a elementos del arreglo CADENA
        String elemento1 = CADENA['b' - 'a'][-3 - (-5)];
        String elemento2 = CADENA['e' - 'a'][4 - (-5)];
        String elemento3 = CADENA['z' - 'a'][7 - (-5)];

        System.out.println("Elemento 1: " + elemento1);
        System.out.println("Elemento 2: " + elemento2);
        System.out.println("Elemento 3: " + elemento3);
        System.out.println("NTE: " + NTE);
    }
}

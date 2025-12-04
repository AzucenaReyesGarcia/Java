package ejercicios;

public class PS_4_17 {
    public static void main(String[] args) {
        System.out.println("Tabla de multiplicar del 1 al 10:");
        System.out.println();

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                int resultado = i * j;
                System.out.printf("%2d x %2d = %3d   ", i, j, resultado);
            }
            System.out.println();
        }
    }
}

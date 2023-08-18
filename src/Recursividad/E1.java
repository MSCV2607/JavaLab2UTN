package Recursividad;

import java.util.Scanner;

public class E1 {

    //Recursion
    public static int dividir(int dividendo, int divisor) {
        if (divisor == 0) {
            System.out.println("No se puede dividir un número por 0");
            return 0;
        } else if (dividendo < divisor) {
            return 0;
        } else {
            return 1 + dividir(dividendo - divisor, divisor);
        }
    }

    //Metodo para elegir la recursividad o la iteracion
    public static int dividir(int dividendo, int divisor, boolean recursion) {
        if (recursion) {
            return dividir(dividendo, divisor);
        } else {
            int resultado = 0;
            while (dividendo >= divisor) {
                dividendo -= divisor;
                resultado++;
            }
            return resultado;
        }
    }

    //Main
    public static void main(String[] args) {
        int divisor, dividendo;
        Scanner scanner = new Scanner(System.in);

        // Prueba 1
        divisor = 5;
        dividendo = 25;
        System.out.println("Resultado (Recursivo) para 25 / 5: " + dividir(dividendo, divisor, true));
        System.out.println("Resultado (Iterativo) para 25 / 5: " + dividir(dividendo, divisor, false));

        // Prueba 2
        divisor = 5;
        dividendo = 40;
        System.out.println("Resultado (Recursivo) para 40 / 5: " + dividir(dividendo, divisor, true));
        System.out.println("Resultado (Iterativo) para 40 / 5: " + dividir(dividendo, divisor, false));



        // Prueba final con entrada del usuario
        System.out.println("Ingrese el divisor");
        divisor = scanner.nextInt();

        System.out.println("Ingrese el dividendo");
        dividendo = scanner.nextInt();

        int resultadoRecursivo = dividir(dividendo, divisor, true);
        int resultadoIterativo = dividir(dividendo, divisor, false);

        System.out.println("Resultado (Recursivo): " + resultadoRecursivo);
        System.out.println("Resultado (Iterativo): " + resultadoIterativo);
    }
}

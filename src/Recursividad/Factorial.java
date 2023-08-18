package Recursividad;

public class Factorial {

    //Metodo publico que usa recursion para calcular el factorial
    public static int calcularFactorial(int n) {
        return calcularFactorialRecursivo(n);
    }

    //Metodo publico y sobrecargado que puede usar iteracion o recusion
    public static int calcularFactorial(int n, boolean usarRecursivo) {
        if (usarRecursivo) {
            return calcularFactorialRecursivo(n);
        } else {
            return calcularFactorialIterativo(n);
        }
    }

    //Metodo privado (para no romper encapsulacion) que calcula el factorial con recursividad
    private static int calcularFactorialRecursivo(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * calcularFactorialRecursivo(n - 1);
        }
    }

    //Metodo privado (para no romper encapsulacion) que calcula el factorial con iteracion
    private static int calcularFactorialIterativo(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
//Para no romper la encapsulacion uso private static ya que lo usare en esta clase y public a aquello
//que interactue con la clase E3
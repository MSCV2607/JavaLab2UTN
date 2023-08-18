package Recursividad;
import java.util.Scanner;

//Esta clase, con el metodo main, interactua con la clase Factorial para realizar el factorial de los numeros

public class E3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //El usuario ingresa un numero para sacar el factorial con recursividad
        System.out.print("Ingrese un número para calcularlo con recursividad: ");
        int numero = scanner.nextInt();
        int factorialRecursivo = Factorial.calcularFactorial(numero, true);
        System.out.println("Factorial (Recursivo) de " + numero + ": " + factorialRecursivo);

        //El usuario ingresa un numero para sacar el factorial con iteracion
        System.out.print("Ingrese un número para calcularlo con iteracion: ");
        numero = scanner.nextInt();
        int factorialIterativo = Factorial.calcularFactorial(numero, false);
        System.out.println("Factorial (Iterativo) de " + numero + ": " + factorialIterativo);
    }
}


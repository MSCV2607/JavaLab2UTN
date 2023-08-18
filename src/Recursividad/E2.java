package Recursividad;
import java.util.Scanner;
//Esta clase, con el metodo main, interactua con la clase sumaR para realizar la sumatoria de los numeros
public class E2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Pruebas
        int num1 = 5;
        int num2 = 10;
        int num3 = 3;

        //Impresion de resultados
        System.out.println("Sumatoria de 1 hasta " + num1 + ": " + sumR.sum(num1));
        System.out.println("Sumatoria de 1 hasta " + num2 + ": " + sumR.sum(num2));
        System.out.println("Sumatoria de 1 hasta " + num3 + ": " + sumR.sum(num3));

        //Prueba puesta por el usuario
        System.out.print("Ingrese un número para calcular su sumatoria: ");
        int numX = scanner.nextInt();

        int resultadoSumatoriaUsuario = sumR.sum(numX);

        //Impresion del resultado del numero de entrada
        System.out.println("Sumatoria de 1 hasta " + numX + ": " + resultadoSumatoriaUsuario);
    }
}


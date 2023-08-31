import java.util.Scanner;

public class NumerosOrdeandos {

    public static void main(String[] args) {

        int n1,n2,n3,aux;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el primer número: ");
        n1 = scanner.nextInt();
        System.out.println("Ingrese el segundo número: ");
        n2 = scanner.nextInt();
        System.out.println("Ingrese el tercer número: ");
        n3 = scanner.nextInt();

        if (n1 < n2) {
            aux = n1;
            n1 = n2;
            n2 = aux;
        }
        if (n2 < n3) {
            aux = n2;
            n2 = n3;
            n3 = aux;
        }
        if (n1 < n2) {
            aux = n1;
            n1 = n2;
            n2 = aux;
        }

        System.out.println("Los numeros de mayor a menor son: "+n1+","+n2+","+n3);



    }


}

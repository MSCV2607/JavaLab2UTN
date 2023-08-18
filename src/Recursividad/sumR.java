package Recursividad;
//Clase que usa recursividad para realizar la sumatoria
public class sumR {
    public static int sum(int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        } else {
            return num + sum(num - 1);
        }
    }

}

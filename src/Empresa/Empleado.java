package Empresa;
// Clase abstracta que se usa como molde para todos los tipos de empleados
abstract class Empleado {
    protected String nombre;
    protected int id;
    protected double sueldoBase;

    // Constructor de la clase Empleado
    protected Empleado(String nombre, int id, double sueldoBase) {
        this.nombre = nombre;
        this.id = id;
        this.sueldoBase = sueldoBase;
    }

    // Método abstracto para calcular el sueldo del empleado
    protected abstract double calcularSueldo();
}

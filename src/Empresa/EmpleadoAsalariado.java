package Empresa;
// Clase que representa a un Empleado asalariado
class EmpleadoAsalariado extends Empleado implements Impuesto {
    // Constructor de la clase EmpleadoAsalariado
    protected EmpleadoAsalariado(String nombre, int id, double sueldoBase) {
        super(nombre, id, sueldoBase);
    }

    // Implementación del método abstracto para calcular el sueldo del empleado asalariado
    @Override
    protected double calcularSueldo() {
        return sueldoBase;
    }

    // Implementación del método de la interfaz Impuesto para calcular el impuesto a pagar
    @Override
    public double calcularImpuesto() {
        return calcularSueldo() * 0.21; // 21% de impuesto
    }
}

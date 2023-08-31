package Empresa;

class EmpleadoComision extends Empleado implements Impuesto {
    public double ventasRealizadas;

    // Constructor de la clase EmpleadoComision
    public EmpleadoComision(String nombre, int id, double sueldoBase, double ventasRealizadas) {
        super(nombre, id, sueldoBase);
        this.ventasRealizadas = ventasRealizadas;
    }

    // Implementación del método abstracto para calcular el sueldo del empleado con comisión
    @Override
    protected double calcularSueldo() {
        return sueldoBase + (0.1 * ventasRealizadas); // 10% de comisión
    }

    // Implementación del método de la interfaz Impuesto para calcular el impuesto a pagar
    @Override
    public double calcularImpuesto() {
        return calcularSueldo() * 0.21; // 21% de impuesto
    }
}

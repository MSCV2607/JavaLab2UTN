package Empresa;

class EmpleadoPorHoras extends Empleado implements Impuesto {
    public int horasTrabajadas;

    // Constructor de la clase EmpleadoPorHoras
    public EmpleadoPorHoras(String nombre, int id, double sueldoBase, int horasTrabajadas) {
        super(nombre, id, sueldoBase);
        this.horasTrabajadas = horasTrabajadas;
    }

    // Implementación del método abstracto para calcular el sueldo del empleado por horas
    @Override
    public double calcularSueldo() {
        return sueldoBase * horasTrabajadas;
    }

    // Implementación del método de la interfaz Impuesto para calcular el impuesto a pagar
    @Override
    public double calcularImpuesto() {
        return calcularSueldo() * 0.21; // 21% de impuesto
    }
}

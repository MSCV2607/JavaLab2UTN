package Empresa;

import java.util.ArrayList;

// Clase para gestionar los empleados
class GestorEmpleados {
    public ArrayList<Empleado> empleados = new ArrayList<>();

    // Método para agregar un empleado al ArrayList
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    // Método para modificar un empleado en el ArrayList
    public void modificarEmpleado(int indice, Empleado empleado) {
        empleados.set(indice, empleado);
    }

    // Método para eliminar un empleado del ArrayList
    public void eliminarEmpleado(int indice) {
        empleados.remove(indice);
    }

    // Método para mostrar la información de todos los empleados
    public void mostrarEmpleados() {
        for (Empleado empleado : empleados) {
            System.out.println("-------------------------");
            System.out.println("Nombre: " + empleado.nombre);
            System.out.println("ID: " + empleado.id);
            System.out.println("Sueldo: " + empleado.calcularSueldo());
            if (empleado instanceof Impuesto) {
                Impuesto empleadoImpuesto = (Impuesto) empleado;
                System.out.println("Impuesto a pagar: " + empleadoImpuesto.calcularImpuesto());
            }
            System.out.println("-------------------------");
        }
    }
}

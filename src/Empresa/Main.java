package Empresa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorEmpleados gestor = new GestorEmpleados();

        while (true) {
            System.out.println("1. Agregar empleado");
            System.out.println("2. Modificar empleado");
            System.out.println("3. Eliminar empleado");
            System.out.println("4. Mostrar empleados");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Solicitar información del nuevo empleado
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Sueldo base: ");
                    double sueldoBase = scanner.nextDouble();
                    System.out.println("Tipo de empleado:");
                    System.out.println("1. Empleado por horas");
                    System.out.println("2. Empleado asalariado");
                    System.out.println("3. Empleado comisión");
                    System.out.print("Opción: ");
                    int tipoEmpleado = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    // Crear un nuevo empleado según el tipo seleccionado
                    Empleado nuevoEmpleado = null;
                    switch (tipoEmpleado) {
                        case 1:
                            System.out.print("Horas trabajadas: ");
                            int horasTrabajadas = scanner.nextInt();
                            nuevoEmpleado = new EmpleadoPorHoras(nombre, id, sueldoBase, horasTrabajadas);
                            break;
                        case 2:
                            nuevoEmpleado = new EmpleadoAsalariado(nombre, id, sueldoBase);
                            break;
                        case 3:
                            System.out.print("Ventas realizadas: ");
                            double ventasRealizadas = scanner.nextDouble();
                            nuevoEmpleado = new EmpleadoComision(nombre, id, sueldoBase, ventasRealizadas);
                            break;
                        default:
                            System.out.println("Opción inválida.");
                    }

                    // Agregar el nuevo empleado al gestor
                    if (nuevoEmpleado != null) {
                        gestor.agregarEmpleado(nuevoEmpleado);
                        System.out.println("Empleado agregado.");
                    }
                    break;
                case 2:
                    System.out.print("Índice del empleado a modificar: ");
                    int indiceModificar = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    if (indiceModificar >= 0 && indiceModificar < gestor.empleados.size()) {
                        Empleado empleadoActual = gestor.empleados.get(indiceModificar);
                        System.out.println("Modificar empleado: " + empleadoActual.nombre);

                        if (empleadoActual instanceof EmpleadoPorHoras) {
                            EmpleadoPorHoras empleadoPorHoras = (EmpleadoPorHoras) empleadoActual;
                            System.out.print("Nuevas horas trabajadas: ");
                            int nuevasHoras = scanner.nextInt();
                            empleadoPorHoras.horasTrabajadas = nuevasHoras;
                        } else if (empleadoActual instanceof EmpleadoAsalariado) {
                            EmpleadoAsalariado empleadoAsalariado = (EmpleadoAsalariado) empleadoActual;
                            System.out.print("Nuevo sueldo base: ");
                            double nuevoSueldoBase = scanner.nextDouble();
                            empleadoAsalariado.sueldoBase = nuevoSueldoBase;
                        } else if (empleadoActual instanceof EmpleadoComision) {
                            EmpleadoComision empleadoComision = (EmpleadoComision) empleadoActual;
                            System.out.print("Nuevas ventas realizadas: ");
                            double nuevasVentas = scanner.nextDouble();
                            empleadoComision.ventasRealizadas = nuevasVentas;
                        }

                        // Modificar el empleado en el gestor
                        gestor.modificarEmpleado(indiceModificar, empleadoActual);
                        System.out.println("Empleado modificado.");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                case 3:
                    System.out.print("Índice del empleado a eliminar: ");
                    int indiceEliminar = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    if (indiceEliminar >= 0 && indiceEliminar < gestor.empleados.size()) {
                        Empleado empleadoEliminado = gestor.empleados.remove(indiceEliminar);
                        System.out.println("Empleado eliminado: " + empleadoEliminado.nombre);
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                case 4:
                    // Mostrar información de los empleados
                    gestor.mostrarEmpleados();
                    break;
                case 5:
                    System.out.println("Gracias por usar el programa.");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}



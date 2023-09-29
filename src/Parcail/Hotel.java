package Parcail;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Hospital implements Serializable {
    private static List <Doctor> doctores = new ArrayList <>();
    private static List <Paciente> pacientes = new ArrayList <>();
    private static int pacienteID = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hospital Julio C. Perrando - Av. 9 de Julio 1100 · 0362 444-2399");
        System.out.println("--------------------------------------");
        System.out.println("Menu: ");
        System.out.println("Op1: Listar Doctores.");
        System.out.println("Op2: Registrar un nuevo paciente.");
        System.out.println("Op3: Actualizar información personal de un paciente.");
        System.out.println("Op4: Consultar el historial médico de un paciente.");
        System.out.println("Op5: Nuevo historial para un paciente. ");
        System.out.println("Op6: Guardar Historial de pacientes en archivo");
        System.out.println("Op7: Cargar Historial de pacientes desde archivo");
        System.out.println("Op8: Salir");
        System.out.println("--------------------------------------");


        Doctor doctor1 = new Doctor("Juan Pepito", 42741205, 1999, "Corazon");
        Doctor doctor2 = new Doctor("Manuel Roberto", 3047810, 1970, "Higado");

        doctores.add(doctor1);
        doctores.add(doctor2);


        int numero;

        do {
            System.out.println("Numero: ");
            numero = scanner.nextInt();

            switch (numero) {
                case 1:
                    listarDoctores();
                    break;
                case 2:
                    registrarNuevoPaciente(scanner);
                    break;
                case 3:
                    actualizarInformacionPaciente(scanner);
                    break;
                case 4:
                    consultarHistorialMedico(scanner);
                    break;
                case 5:
                    agregarEventoHistorial(scanner);
                    break;
                case 6:
                    guardarPacientes();
                    break;
                case 7:
                    cargarDatosContacto();
                    break;
                case 8:
                    System.out.println("Muchas Gracias por usar el programa que tenga un Buen día!!");
                    break;
                default:
                    System.out.println("Usted ha tocado un número diferente entre 1 a 6, vuelva a intentarlo");
                    break;
            }
        } while (numero != 8);
        scanner.close();
    }

    private static void listarDoctores() {
        System.out.println("Doctores:");
        for (Doctor doctor : doctores) {
            System.out.println("Nombre: " + doctor.getNombre());
            System.out.println("DNI: " + doctor.getDNI());
            System.out.println("Especialidad: " + doctor.getEspecialidad());
            System.out.println("-----------------------");
        }
    }

    private static void registrarNuevoPaciente(Scanner scanner) {
        System.out.println("Ingrese el nombre del paciente:");
        String nombre = scanner.next();
        System.out.println("Ingrese el DNI del paciente:");
        int dni = scanner.nextInt();
        System.out.println("Ingrese la fecha de nacimiento del paciente (formato dd/MM/yyyy escriba todo junto):");
        int fechaN = scanner.nextInt();
        System.out.println("Ingrese el número de teléfono del paciente:");
        int numT = scanner.nextInt();
        System.out.println("Ingrese el tipo de sangre del paciente:");
        String tipoSan = scanner.next();

        Paciente nuevoPaciente = new Paciente(nombre, dni, fechaN, numT, tipoSan);
        pacientes.add(nuevoPaciente);
        System.out.println("Paciente registrado con éxito.");
    }

    private static void actualizarInformacionPaciente(Scanner scanner) {
        System.out.println("Ingrese el DNI del paciente que desea actualizar:");
        int dniBuscado = scanner.nextInt();

        boolean pacienteEncontrado = false;
        for (Paciente paciente : pacientes) {
            if (paciente.getDNI() == dniBuscado) {
                pacienteEncontrado = true;
                System.out.println("Paciente encontrado. Ingrese la nueva información:");


                System.out.println("Nuevo nombre:");
                String nuevoNombre = scanner.next();
                paciente.setNombre(nuevoNombre);

                System.out.println("Nueva fecha de nacimiento (dd/MM/yyyy):");
                int nuevaFechaN = scanner.nextInt();
                paciente.setFechaN(nuevaFechaN);


                System.out.println("Información del paciente actualizada con éxito.");
                break;
            }
        }

        if (!pacienteEncontrado) {
            System.out.println("Paciente no encontrado.");
        }
    }


    private static void consultarHistorialMedico(Scanner scanner) {
        System.out.println("Indique el DNI del paciente a buscar:");
        int dniBuscado = scanner.nextInt();

        boolean pacienteEncontrado = false;
        for (Paciente paciente : pacientes) {
            if (paciente.getDNI() == dniBuscado) {
                pacienteEncontrado = true;
                System.out.println("HISTORIAL MÉDICO:");

                for (String evento : paciente.getHistorialMedico()) {
                    System.out.println(evento);
                }
                break;
            }
        }

        if (!pacienteEncontrado) {
            System.out.println("Paciente no encontrado.");
        }
    }

    private static void agregarEventoHistorial(Scanner scanner) {
        System.out.println("Ingrese el DNI del paciente al que desea agregar un evento al historial:");
        int dniBuscado = scanner.nextInt();

        boolean pacienteEncontrado = false;
        for (Paciente paciente : pacientes) {
            if (paciente.getDNI() == dniBuscado) {
                pacienteEncontrado = true;
                System.out.println("Ingrese la fecha del evento (dd/MM/yyyy):");
                String fecha = scanner.next();
                System.out.println("Ingrese las observaciones:");
                String observaciones = scanner.next();

                String evento = fecha + " - " + observaciones;
                paciente.historialMedico(evento);

                System.out.println("Evento agregado al historial médico con éxito.");
                break;
            }
        }

        if (!pacienteEncontrado) {
            System.out.println("Paciente no encontrado.");
        }
    }

    static class crearPersona {
        private String nombre;
        private int DNI;
        private int fechaN;

        public crearPersona() {
        }

        public crearPersona(String nombre, int DNI, int fechaN) {
            this.nombre = nombre;
            this.DNI = DNI;
            this.fechaN = fechaN;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getDNI() {
            return DNI;
        }

        public void setDNI(int DNI) {
            this.DNI = DNI;
        }

        public int getFechaN() {
            return fechaN;
        }

        public void setFechaN(int fechaN) {
            this.fechaN = fechaN;
        }
    }

    static class Doctor extends crearPersona {
        private String especialidad;

        public Doctor(String nombre, int DNI, int fechaN, String especialidad) {
            super(nombre, DNI, fechaN);
            this.especialidad = especialidad;
        }

        public String getEspecialidad() {
            return especialidad;
        }

        public void setEspecialidad(String especialidad) {
            this.especialidad = especialidad;
        }
    }

    static class Paciente extends crearPersona implements Informacion {
        private int numT;
        private String tipoSan;
        private List <String> historialMedico;

        public Paciente(String nombre, int DNI, int fechaN, int numT, String tipoSan) {
            super(nombre, DNI, fechaN);
            this.numT = numT;
            this.tipoSan = tipoSan;
            this.historialMedico = new ArrayList <>();
        }

        public int getNumT() {
            return numT;
        }

        public void setNumT(int numT) {
            this.numT = numT;
        }

        public String getTipoSan() {
            return tipoSan;
        }

        public void setTipoSan(String tipoSan) {
            this.tipoSan = tipoSan;
        }

        public List <String> getHistorialMedico() {
            return historialMedico;
        }

        @Override
        public void Informacion() {
            // Implementa el método Informacion
        }

        @Override
        public void historialMedico(String huesped) {
            historialMedico.add(huesped);
        }
    }

    public interface Informacion {
        void Informacion();

        void historialMedico(String huesped);
    }


    private static void cargarDatosContacto() {
        try {
            File archivo = new File("datos.txt");
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                System.out.println(linea);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo de datos de contacto.");
        }
    }

    private static void guardarPacientes() {
        try {
            FileOutputStream fileOut = new FileOutputStream("pacientes.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(pacientes);
            out.close();
            fileOut.close();
            System.out.println("Datos de pacientes guardados con éxito.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos de pacientes.");
        }
    }


    private static void recuperarPacientes() {
        try {
            FileInputStream fileIn = new FileInputStream("pacientes.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            pacientes = (List <Paciente>) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Datos de pacientes recuperados con éxito.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al recuperar los datos de pacientes.");
        }
    }
}

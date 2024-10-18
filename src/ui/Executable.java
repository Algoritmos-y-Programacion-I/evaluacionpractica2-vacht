package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

    private Controller control;
    private Scanner reader;

    public Executable() {
        control = new Controller();
        reader = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Executable exe = new Executable();
        exe.menu();
    }

    /** 
     * Descripcion: Despliega el menu principal de funcionalidades al usuario.
     * Precondiciones: El controlador debe estar inicializado y listo para gestionar los pilares.
     * Postcondiciones: Muestra el menú al usuario y permite la interacción con el sistema.
     */
    public void menu() {
        boolean flag = true;

        do {
            System.out.println("\nBienvenido a Icesi Sostenible!");
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("----------------------");
            System.out.println("1) Registrar un Proyecto en un Pilar");
            System.out.println("2) Consultar Proyectos por Pilar");
            System.out.println("0) Salir");
            int option = reader.nextInt();

            switch (option) {
                case 1:
                    registerProject();
                    break;
                case 2:
                    showProjectsByPillar();
                    break;
                case 0:
                    System.out.println("Gracias por usar nuestros servicios. Adios!");
                    flag = false;
                    break;
                default:
                    System.out.println("Opcion invalida, intente nuevamente");
                    break;
            }

        } while (flag);
    }

    /** 
     * Descripcion: Solicita al usuario la informacion necesaria para registrar un Project 
     * en un Pillar en el sistema.
     * Precondiciones: El sistema debe estar en ejecución y el usuario debe tener acceso.
     * Postcondiciones: Registra un proyecto en el pilar seleccionado si es válido.
     */
    public void registerProject() {
        System.out.println("Seleccione el pilar: 0) Biodiversidad, 1) Agua, 2) Basuras, 3) Energía");
        int pillarType = reader.nextInt();
        reader.nextLine(); // Consumir la nueva línea

        System.out.println("Ingrese el ID del proyecto:");
        String id = reader.nextLine();

        System.out.println("Ingrese el nombre del proyecto:");
        String name = reader.nextLine();

        System.out.println("Ingrese la descripción del proyecto:");
        String description = reader.nextLine();

        System.out.println("Ingrese el estado del proyecto (1 para activo, 0 para inactivo):");
        int statusInput = reader.nextInt(); // Cambiado a int para leer 1 o 0
        boolean status = (statusInput == 1); // Asigna true si es 1, false si es 0


        boolean result = control.registerProjectInPillar(pillarType, id, name, description, status);

        if (result) {
            System.out.println("¡Proyecto registrado exitosamente!");
        } else {
            System.out.println("No se pudo registrar el proyecto.");
        }
    }

    /** 
     * Descripcion: Muestra al usuario los Projects registrados en un Pillar 
     * Precondiciones: El sistema debe estar en ejecución y el usuario debe tener acceso.
     * Postcondiciones: Muestra la lista de proyectos registrados en el pilar seleccionado.
     */
    public void showProjectsByPillar() {
        System.out.println("Seleccione el pilar: 0) Biodiversidad, 1) Agua, 2) Basuras, 3) Energía");
        int pillarType = reader.nextInt();

        String projects = control.queryProjectsByPillar(pillarType);
        System.out.println(projects);
    }
}

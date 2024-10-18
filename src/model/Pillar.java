package model;

public class Pillar {

    private String name; // Nombre del pilar
    private Project[] projects; // Arreglo de proyectos

    public Pillar(String name) {
        this.name = name;
        projects = new Project[50]; // Inicializa el arreglo para un máximo de 50 proyectos
    }

    /**
     * Descripcion: Añade un nuevo Project al arreglo projects.
     * Precondiciones: El arreglo projects debe estar inicializado.
     * Postcondiciones: Se añade el nuevo proyecto si hay espacio disponible en el arreglo.
     * @param newProject Project El Project que se va a añadir.
     * @return boolean true si se logra añadir el Project, false en caso contrario.
     */
    public boolean registerProject(Project newProject) {
        for (int i = 0; i < projects.length; i++) {
            if (projects[i] == null) {
                projects[i] = newProject;
                return true;
            }
        }
        return false; // Si no hay espacio, retorna false
    }

    /**
     * Descripcion: Genera una cadena en formato lista con la información de los
     * Project registrados en el Pillar, incluyendo su nombre.
     * Precondiciones: El arreglo projects debe estar inicializado.
     * Postcondiciones: Retorna una lista con la información de todos los proyectos registrados.
     * @return String con la lista de proyectos.
     */
    public String getProjectList() {
        StringBuilder list = new StringBuilder("Pilar: ").append(name).append("\nProyectos:\n");
        for (Project project : projects) {
            if (project != null) {
                list.append("ID: ").append(project.getId())
                    .append(", Nombre: ").append(project.getName())
                    .append(", Estado: ").append(project.isStatus() ? "Activo" : "Inactivo")
                    .append(", Descripción: ").append(project.getDescription())
                    .append("\n");
            }
        }
        return list.toString(); // Retorna la lista de proyectos
    }
}

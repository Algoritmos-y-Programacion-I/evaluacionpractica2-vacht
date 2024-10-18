package model;

public class Project {

    private String id; // Identificador del proyecto
    private String name; // Nombre del proyecto
    private String description; // Descripción del proyecto
    private boolean status; // Estado del proyecto (activo o inactivo)

    public Project(String id, String name, String description, boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    /**
     * Descripcion: Obtiene el identificador del proyecto.
     * Precondiciones: El proyecto debe estar inicializado.
     * Postcondiciones: Retorna el ID del proyecto.
     * @return String con el identificador del proyecto.
     */
    public String getId() {
        return id;
    }

    /**
     * Descripcion: Obtiene el nombre del proyecto.
     * Precondiciones: El proyecto debe estar inicializado.
     * Postcondiciones: Retorna el nombre del proyecto.
     * @return String con el nombre del proyecto.
     */
    public String getName() {
        return name;
    }

    /**
     * Descripcion: Verifica si el proyecto está activo.
     * Precondiciones: El proyecto debe estar inicializado.
     * Postcondiciones: Retorna true si el proyecto está activo, false si está inactivo.
     * @return boolean el estado del proyecto.
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Descripcion: Obtiene la descripción del proyecto.
     * Precondiciones: El proyecto debe estar inicializado.
     * Postcondiciones: Retorna la descripción del proyecto.
     * @return String con la descripción del proyecto.
     */
    public String getDescription() {
        return description;
    }
}

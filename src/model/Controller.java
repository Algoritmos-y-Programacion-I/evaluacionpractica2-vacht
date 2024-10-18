package model;

public class Controller {

    private Pillar[] pillars;

    public Controller() {
        pillars = new Pillar[4];
        pillars[0] = new Pillar("Biodiversidad");
        pillars[1] = new Pillar("Agua");
        pillars[2] = new Pillar("Tratamiento de Basuras");
        pillars[3] = new Pillar("Energía");
    }

    /**
     * Descripcion: Permite crear y añadir un Project en un Pillar en el sistema.
     * Precondiciones: El tipo de pilar debe ser un valor válido (0 a 3).
     * Postcondiciones: Se registra un nuevo proyecto en el pilar seleccionado si es válido.
     * @param pillarType Tipo de pilar donde se registrará el proyecto.
     * @param id Identificador del proyecto.
     * @param name Nombre del proyecto.
     * @param description Descripción del proyecto.
     * @param status Estado del proyecto (activo o inactivo).
     * @return boolean true si se logra añadir el Project en el Pillar, false en caso contrario.
     */
    public boolean registerProjectInPillar(int pillarType, String id, String name, String description, boolean status) {
        if (pillarType >= 0 && pillarType < pillars.length) {
            Project newProject = new Project(id, name, description, status);
            return pillars[pillarType].registerProject(newProject);
        }
        return false;
    }

    /**
     * Descripcion: Retorna la información de los Project registrados en un Pillar.
     * Precondiciones: El tipo de pilar debe ser un valor válido (0 a 3).
     * Postcondiciones: Retorna la lista de proyectos registrados en el pilar especificado.
     * @param pillarType Tipo de pilar del cual se desea obtener información.
     * @return String con la información de los Projects registrados, o un mensaje de error si no se encuentra el pilar.
     */
    public String queryProjectsByPillar(int pillarType) {
        if (pillarType >= 0 && pillarType < pillars.length) {
            return pillars[pillarType].getProjectList();
        }
        return "Pilar no encontrado.";
    }
}

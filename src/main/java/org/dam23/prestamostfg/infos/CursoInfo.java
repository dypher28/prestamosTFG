package org.dam23.prestamostfg.infos;

import java.util.Set;

/**
 * Projection for {@link org.dam23.prestamostfg.entities.Curso}
 */
public interface CursoInfo {
    Integer getId();

    String getNombreCurso();

    Set<AsignaturaInfo> getAsignaturas();

    Set<MatriculaInfo> getMatriculas();

    Set<PaqueteInfo> getPaquetes();

    /**
     * Projection for {@link org.dam23.prestamostfg.entities.Asignatura}
     */
    interface AsignaturaInfo {
        Integer getId();

        String getNombre();
    }

    /**
     * Projection for {@link org.dam23.prestamostfg.entities.Matricula}
     */
    interface MatriculaInfo {
        Integer getId();

        String getGrupo();

        String getAnioEscolar();

        AlumnoInfo getAlumno();

        /**
         * Projection for {@link org.dam23.prestamostfg.entities.Alumno}
         */
        interface AlumnoInfo {
            Integer getId();

            String getNombre();

            String getApellidos();
        }
    }

    /**
     * Projection for {@link org.dam23.prestamostfg.entities.Paquete}
     */
    interface PaqueteInfo {
        Integer getId();

        String getNombre();
    }
}
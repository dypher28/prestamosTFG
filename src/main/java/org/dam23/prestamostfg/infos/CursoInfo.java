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

    /**
     * Projection for {@link org.dam23.prestamostfg.entities.Asignatura}
     */
    interface AsignaturaInfo {
        Integer getId();

        String getNombre();

        Set<LibroInfo> getLibros();

        /**
         * Projection for {@link org.dam23.prestamostfg.entities.Libro}
         */
        interface LibroInfo {
            Integer getId();

            String getTitulo();
        }
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
        }
    }
}
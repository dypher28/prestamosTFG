package org.dam23.prestamostfg.infos;

import java.util.Set;

/**
 * Projection for {@link org.dam23.prestamostfg.entities.Alumno}
 */
public interface AlumnoInfo {
    Integer getId();

    String getNombre();

    String getApellidos();

    Set<MatriculaInfo> getMatriculas();

    /**
     * Projection for {@link org.dam23.prestamostfg.entities.Matricula}
     */
    interface MatriculaInfo {
        Integer getId();

        String getGrupo();

        String getAnioEscolar();

        CursoInfo1 getCurso();

        /**
         * Projection for {@link org.dam23.prestamostfg.entities.Curso}
         */
        interface CursoInfo1 {
            Integer getId();

            String getNombreCurso();
        }
    }
}
package org.dam23.prestamostfg.infos;

import java.util.Set;

/**
 * Projection for {@link org.dam23.prestamostfg.entities.Curso}
 */
public interface CursoInfo {
    Integer getId();

    String getNombreCurso();

    Set<AsignaturaInfo> getAsignaturas();

    /**
     * Projection for {@link org.dam23.prestamostfg.entities.Asignatura}
     */
    interface AsignaturaInfo {
        Integer getId();

        String getNombre();
    }
}
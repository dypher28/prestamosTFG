package org.dam23.prestamostfg.infos;

import java.util.Set;

/**
 * Projection for {@link org.dam23.prestamostfg.entities.Asignatura}
 */
public interface AsignaturaInfo {
    Integer getId();

    String getNombre();

    CursoInfo1 getCurso();

    Set<LibroInfo> getLibros();

    /**
     * Projection for {@link org.dam23.prestamostfg.entities.Curso}
     */
    interface CursoInfo1 {
        Integer getId();

        String getNombreCurso();
    }

    /**
     * Projection for {@link org.dam23.prestamostfg.entities.Libro}
     */
    interface LibroInfo {
        Integer getId();

        String getTitulo();
    }
}
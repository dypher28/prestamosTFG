package org.dam23.prestamostfg.infos;

/**
 * Projection for {@link org.dam23.prestamostfg.entities.Asignatura}
 */
public interface AsignaturaInfo {
    Integer getId();

    String getNombre();

    CursoInfo1 getCurso();

    /**
     * Projection for {@link org.dam23.prestamostfg.entities.Curso}
     */
    interface CursoInfo1 {
        Integer getId();

        String getNombreCurso();
    }
}
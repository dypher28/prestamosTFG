package org.dam23.prestamostfg.infos;

import java.util.Set;

/**
 * Projection for {@link org.dam23.prestamostfg.entities.Libro}
 */
public interface LibroInfo {
    Integer getId();

    String getTitulo();

    String getEditorial();

    String getIsbn();

    Integer getCantidad();

    AsignaturaInfo1 getAsignatura();

    ImageInfo getImage();

    Set<PaqueteInfo> getPaquetes();

    /**
     * Projection for {@link org.dam23.prestamostfg.entities.Asignatura}
     */
    interface AsignaturaInfo1 {
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

    /**
     * Projection for {@link org.dam23.prestamostfg.entities.Image}
     */
    interface ImageInfo {
        Integer getId();

        String getFileName();

        String getContentType();

        byte[] getData();
    }

    /**
     * Projection for {@link org.dam23.prestamostfg.entities.Paquete}
     */
    interface PaqueteInfo {
        Integer getId();

        String getNombre();
    }
}
package org.dam23.prestamostfg.infos;

import java.time.LocalDate;
import java.util.Set;

/**
 * Projection for {@link org.dam23.prestamostfg.entities.Paquete}
 */
public interface PaqueteInfo {
    Integer getId();

    String getNombre();

    CursoInfo1 getCurso();

    Set<LibroInfo1> getLibros();

    Set<PrestamoInfo> getPrestamos();

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
    interface LibroInfo1 {
        Integer getId();

        String getTitulo();

        String getEditorial();

        String getIsbn();

        Integer getCantidad();

        ImageInfo getImage();

        /**
         * Projection for {@link org.dam23.prestamostfg.entities.Image}
         */
        interface ImageInfo {
            Integer getId();

            String getFileName();

            String getContentType();

            byte[] getData();
        }
    }

    /**
     * Projection for {@link org.dam23.prestamostfg.entities.Prestamo}
     */
    interface PrestamoInfo {
        Integer getId();

        LocalDate getFechaPrestamo();

        LocalDate getFechaDevolucion();

        Boolean isDevuelto();

        MatriculaInfo getMatricula();

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
    }
}
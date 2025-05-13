package org.dam23.prestamostfg.infos;

import java.util.Set;

/**
 * Projection for {@link org.dam23.prestamostfg.entities.Asignatura}
 */
public interface AsignaturaInfo {
    Integer getId();

    String getNombre();

    CursoInfo1 getCurso();

    Set<LibroInfo1> getLibros();

    /**
     * Projection for {@link org.dam23.prestamostfg.entities.Curso}
     */
    interface CursoInfo1 {
        Integer getId();

        String getNombreCurso();

        Set<MatriculaInfo> getMatriculas();

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
}
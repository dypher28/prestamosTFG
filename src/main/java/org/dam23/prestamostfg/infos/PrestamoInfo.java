package org.dam23.prestamostfg.infos;

import java.time.LocalDate;
import java.util.Set;

/**
 * Projection for {@link org.dam23.prestamostfg.entities.Prestamo}
 */
public interface PrestamoInfo {
    Integer getId();

    LocalDate getFechaPrestamo();

    LocalDate getFechaDevolucion();

    Boolean getDevuelto();

    MatriculaInfo1 getMatricula();

    PaqueteInfo1 getPaquete();

    /**
     * Projection for {@link org.dam23.prestamostfg.entities.Matricula}
     */
    interface MatriculaInfo1 {
        Integer getId();

        String getGrupo();

        String getAnioEscolar();

        AlumnoInfo getAlumno();

        CursoInfo1 getCurso();

        /**
         * Projection for {@link org.dam23.prestamostfg.entities.Alumno}
         */
        interface AlumnoInfo {
            Integer getId();

            String getNombre();

            String getApellidos();
        }

        /**
         * Projection for {@link org.dam23.prestamostfg.entities.Curso}
         */
        interface CursoInfo1 {
            Integer getId();

            String getNombreCurso();
        }
    }

    /**
     * Projection for {@link org.dam23.prestamostfg.entities.Paquete}
     */
    interface PaqueteInfo1 {
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
        }
    }
}
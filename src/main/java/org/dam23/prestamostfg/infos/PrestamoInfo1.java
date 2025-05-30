package org.dam23.prestamostfg.infos;

import java.time.LocalDate;

/**
 * Projection for {@link org.dam23.prestamostfg.entities.Prestamo}
 */
public interface PrestamoInfo1 {
    Integer getId();

    LocalDate getFechaPrestamo();

    LocalDate getFechaDevolucion();

    Boolean isDevuelto();

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
    }
}
package org.dam23.prestamostfg.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for {@link org.dam23.prestamostfg.entities.Prestamo}
 */
public class PrestamoDto implements Serializable {
    private final Integer id;
    private final MatriculaDto matricula;
    private final PaqueteDto1 paquete;
    private final LocalDate fechaDevolucion;
    private final Boolean devuelto;

    public PrestamoDto(Integer id, MatriculaDto matricula, PaqueteDto1 paquete, LocalDate fechaDevolucion, Boolean devuelto) {
        this.id = id;
        this.matricula = matricula;
        this.paquete = paquete;
        this.fechaDevolucion = fechaDevolucion;
        this.devuelto = devuelto;
    }

    public Integer getId() {
        return id;
    }

    public MatriculaDto getMatricula() {
        return matricula;
    }

    public PaqueteDto1 getPaquete() {
        return paquete;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public Boolean getDevuelto() {
        return devuelto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrestamoDto entity = (PrestamoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.matricula, entity.matricula) &&
                Objects.equals(this.paquete, entity.paquete) &&
                Objects.equals(this.fechaDevolucion, entity.fechaDevolucion) &&
                Objects.equals(this.devuelto, entity.devuelto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, matricula, paquete, fechaDevolucion, devuelto);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "matricula = " + matricula + ", " +
                "paquete = " + paquete + ", " +
                "fechaDevolucion = " + fechaDevolucion + ", " +
                "devuelto = " + devuelto + ")";
    }

    /**
     * DTO for {@link org.dam23.prestamostfg.entities.Matricula}
     */
    public static class MatriculaDto implements Serializable {
        private final Integer id;

        public MatriculaDto(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MatriculaDto entity = (MatriculaDto) o;
            return Objects.equals(this.id, entity.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ")";
        }
    }

    /**
     * DTO for {@link org.dam23.prestamostfg.entities.Paquete}
     */
    public static class PaqueteDto1 implements Serializable {
        private final Integer id;

        public PaqueteDto1(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PaqueteDto1 entity = (PaqueteDto1) o;
            return Objects.equals(this.id, entity.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ")";
        }
    }
}
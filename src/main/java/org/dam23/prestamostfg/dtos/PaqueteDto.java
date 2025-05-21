package org.dam23.prestamostfg.dtos;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link org.dam23.prestamostfg.entities.Paquete}
 */
public class PaqueteDto implements Serializable {
    private final Integer id;
    private final String nombre;
    private final CursoDto curso;
    private final Set<LibroDto1> libros;

    public PaqueteDto(Integer id, String nombre, CursoDto curso, Set<LibroDto1> libros) {
        this.id = id;
        this.nombre = nombre;
        this.curso = curso;
        this.libros = libros;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public CursoDto getCurso() {
        return curso;
    }

    public Set<LibroDto1> getLibros() {
        return libros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaqueteDto entity = (PaqueteDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nombre, entity.nombre) &&
                Objects.equals(this.curso, entity.curso) &&
                Objects.equals(this.libros, entity.libros);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, curso, libros);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nombre = " + nombre + ", " +
                "curso = " + curso + ", " +
                "libros = " + libros + ")";
    }

    /**
     * DTO for {@link org.dam23.prestamostfg.entities.Curso}
     */
    public static class CursoDto implements Serializable {
        private final Integer id;
        private final String nombreCurso;

        public CursoDto(Integer id, String nombreCurso) {
            this.id = id;
            this.nombreCurso = nombreCurso;
        }

        public Integer getId() {
            return id;
        }

        public String getNombreCurso() {
            return nombreCurso;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CursoDto entity = (CursoDto) o;
            return Objects.equals(this.id, entity.id) &&
                    Objects.equals(this.nombreCurso, entity.nombreCurso);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, nombreCurso);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ", " +
                    "nombreCurso = " + nombreCurso + ")";
        }
    }

    /**
     * DTO for {@link org.dam23.prestamostfg.entities.Libro}
     */
    public static class LibroDto1 implements Serializable {
        private final Integer id;

        public LibroDto1(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LibroDto1 entity = (LibroDto1) o;
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
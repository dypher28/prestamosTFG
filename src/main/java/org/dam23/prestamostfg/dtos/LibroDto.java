package org.dam23.prestamostfg.dtos;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link org.dam23.prestamostfg.entities.Libro}
 */
public class LibroDto implements Serializable {
    private final Integer id;
    private final String titulo;
    private final String editorial;
    private final String isbn;
    private final AsignaturaDto asignatura;
    private final ImageDto image;
    private final Integer cantidad;

    public LibroDto(Integer id, String titulo, String editorial, String isbn, AsignaturaDto asignatura, ImageDto image, Integer cantidad) {
        this.id = id;
        this.titulo = titulo;
        this.editorial = editorial;
        this.isbn = isbn;
        this.asignatura = asignatura;
        this.image = image;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public AsignaturaDto getAsignatura() {
        return asignatura;
    }

    public ImageDto getImage() {
        return image;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibroDto entity = (LibroDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.titulo, entity.titulo) &&
                Objects.equals(this.editorial, entity.editorial) &&
                Objects.equals(this.isbn, entity.isbn) &&
                Objects.equals(this.asignatura, entity.asignatura) &&
                Objects.equals(this.image, entity.image) &&
                Objects.equals(this.cantidad, entity.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, editorial, isbn, asignatura, image, cantidad);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "titulo = " + titulo + ", " +
                "editorial = " + editorial + ", " +
                "isbn = " + isbn + ", " +
                "asignatura = " + asignatura + ", " +
                "image = " + image + ", " +
                "cantidad = " + cantidad + ")";
    }

    /**
     * DTO for {@link org.dam23.prestamostfg.entities.Asignatura}
     */
    public static class AsignaturaDto implements Serializable {
        private final Integer id;
        private final String nombre;
        private final CursoDto curso;

        public AsignaturaDto(Integer id, String nombre, CursoDto curso) {
            this.id = id;
            this.nombre = nombre;
            this.curso = curso;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AsignaturaDto entity = (AsignaturaDto) o;
            return Objects.equals(this.id, entity.id) &&
                    Objects.equals(this.nombre, entity.nombre) &&
                    Objects.equals(this.curso, entity.curso);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, nombre, curso);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ", " +
                    "nombre = " + nombre + ", " +
                    "curso = " + curso + ")";
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
    }

    /**
     * DTO for {@link org.dam23.prestamostfg.entities.Image}
     */
    public static class ImageDto implements Serializable {
        private final Integer id;
        private final String fileName;
        private final String contentType;
        private final byte[] data;

        public ImageDto(Integer id, String fileName, String contentType, byte[] data) {
            this.id = id;
            this.fileName = fileName;
            this.contentType = contentType;
            this.data = data;
        }

        public Integer getId() {
            return id;
        }

        public String getFileName() {
            return fileName;
        }

        public String getContentType() {
            return contentType;
        }

        public byte[] getData() {
            return data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ImageDto entity = (ImageDto) o;
            return Objects.equals(this.id, entity.id) &&
                    Objects.equals(this.fileName, entity.fileName) &&
                    Objects.equals(this.contentType, entity.contentType) &&
                    Objects.equals(this.data, entity.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, fileName, contentType, data);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ", " +
                    "fileName = " + fileName + ", " +
                    "contentType = " + contentType + ", " +
                    "data = " + data + ")";
        }
    }
}
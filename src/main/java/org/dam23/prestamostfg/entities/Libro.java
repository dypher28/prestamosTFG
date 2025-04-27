package org.dam23.prestamostfg.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('libros_id_libro_seq')")
    @Column(name = "id_libro", nullable = false)
    private Integer id;

    @Column(name = "titulo", length = 100)
    private String titulo;

    @Column(name = "editorial", length = 100)
    private String editorial;

    @Column(name = "isbn", length = 20)
    private String isbn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @Column(name = "url_image", length = Integer.MAX_VALUE)
    private String urlImage;

    @OneToMany(mappedBy = "idLibro")
    private Set<PrestamosLibro> prestamosLibro = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Set<PrestamosLibro> getPrestamosLibro() {
        return prestamosLibro;
    }

    public void setPrestamosLibro(Set<PrestamosLibro> prestamosLibro) {
        this.prestamosLibro = prestamosLibro;
    }
}
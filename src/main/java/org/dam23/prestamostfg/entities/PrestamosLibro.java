package org.dam23.prestamostfg.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "prestamos_libros")
public class PrestamosLibro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_prestamo", nullable = false)
    private Prestamo idPrestamo;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_libro", nullable = false)
    private Libro idLibro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Prestamo getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Prestamo idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Libro getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Libro idLibro) {
        this.idLibro = idLibro;
    }

}
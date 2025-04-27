package org.dam23.prestamostfg.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "prestamos")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prestamos_id_gen")
    @SequenceGenerator(name = "prestamos_id_gen", sequenceName = "prestamos_id_prestamo_seq", allocationSize = 1)
    @Column(name = "id_prestamo", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matricula_id")
    private Matricula matricula;

    @Column(name = "fecha_prestamo")
    private LocalDate fechaPrestamo;

    @Column(name = "fecha_devolucion")
    private LocalDate fechaDevolucion;

    @Column(name = "devuelto")
    private Boolean devuelto;

    @OneToMany(mappedBy = "idPrestamo")
    private Set<PrestamosLibro> prestamosLibros = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Boolean getDevuelto() {
        return devuelto;
    }

    public void setDevuelto(Boolean devuelto) {
        this.devuelto = devuelto;
    }

    public Set<PrestamosLibro> getPrestamosLibros() {
        return prestamosLibros;
    }

    public void setPrestamosLibros(Set<PrestamosLibro> prestamosLibros) {
        this.prestamosLibros = prestamosLibros;
    }
}
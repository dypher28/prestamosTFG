package org.dam23.prestamostfg.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('cursos_id_curso_seq')")
    @Column(name = "id_curso", nullable = false)
    private Integer id;

    @Column(name = "nombre_curso", length = 100)
    private String nombreCurso;

    @OneToMany(mappedBy = "curso")
    private Set<Asignatura> asignaturas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "curso")
    private Set<Matricula> matriculas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "curso")
    private Set<Paquete> paquetes = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Set<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Set<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public Set<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(Set<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public Set<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(Set<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

}
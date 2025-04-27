package org.dam23.prestamostfg.repositories;

import org.dam23.prestamostfg.entities.Matricula;
import org.dam23.prestamostfg.infos.AlumnoInfo;
import org.dam23.prestamostfg.infos.MatriculaInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {

    List<MatriculaInfo> findAllBy();

    // Obtener matriculas por nombre de alumno
    @Query("select m from Matricula m where upper(m.alumno.nombre) like upper(concat('%', ?1, '%'))")
    List<MatriculaInfo> findByNombreAlumno(String nombre);

    // Obtener matriculas por curso
    @Query("select m from Matricula m where upper(m.curso.nombreCurso) like upper(concat('%', ?1, '%'))")
    List<Matricula> findByCurso(String nombreCurso);

    // Obtener matriculas por grupo
    @Query("select m from Matricula m where upper(m.grupo) like upper(concat('%', ?1, '%'))")
    List<Matricula> findByGrupo(String grupo);

    // Obtener matriculas por año escolar (2024-2025)
    @Query("select m from Matricula m where upper(m.anioEscolar) like upper(?1)")
    List<Matricula> findByAnioEscolar(String anioEscolar);


}
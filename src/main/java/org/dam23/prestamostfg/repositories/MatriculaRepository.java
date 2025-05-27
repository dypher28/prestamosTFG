package org.dam23.prestamostfg.repositories;

import org.dam23.prestamostfg.entities.Matricula;
import org.dam23.prestamostfg.infos.MatriculaInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {

    List<MatriculaInfo> findAllByOrderById();

    List<MatriculaInfo> findByAlumno_NombreContainsIgnoreCaseOrAlumno_ApellidosContainsIgnoreCase(String nombre, String apellidos);


}
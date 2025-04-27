package org.dam23.prestamostfg.repositories;

import org.dam23.prestamostfg.entities.Alumno;
import org.dam23.prestamostfg.infos.AlumnoInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

    List<AlumnoInfo> findAllBy();
}
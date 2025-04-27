package org.dam23.prestamostfg.repositories;

import org.dam23.prestamostfg.entities.Asignatura;
import org.dam23.prestamostfg.infos.AsignaturaInfo;
import org.dam23.prestamostfg.infos.CursoInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer> {

    List<AsignaturaInfo> findAllBy();
}
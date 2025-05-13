package org.dam23.prestamostfg.repositories;

import org.dam23.prestamostfg.entities.Asignatura;
import org.dam23.prestamostfg.infos.AsignaturaInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer> {

    List<AsignaturaInfo> findAllByOrderById();
    AsignaturaInfo findAsignaturaById(Integer idAsignatura);
}
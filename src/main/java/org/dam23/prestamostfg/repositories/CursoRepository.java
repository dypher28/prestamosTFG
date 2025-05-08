package org.dam23.prestamostfg.repositories;

import org.dam23.prestamostfg.entities.Curso;
import org.dam23.prestamostfg.infos.CursoInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

    List<CursoInfo> findAllByOrderById();
    CursoInfo findCursoById(Integer idCurso);
}